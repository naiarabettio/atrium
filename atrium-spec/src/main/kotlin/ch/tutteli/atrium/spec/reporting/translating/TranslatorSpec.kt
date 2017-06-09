package ch.tutteli.atrium.spec.reporting.translating

import ch.tutteli.atrium.reporting.translating.ISimpleTranslatable
import ch.tutteli.atrium.reporting.translating.ITranslatable
import ch.tutteli.atrium.reporting.translating.ITranslationSupplier
import ch.tutteli.atrium.reporting.translating.ITranslator
import ch.tutteli.atrium.spec.IAssertionVerbFactory
import ch.tutteli.atrium.toBe
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.SpecBody
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import java.util.*

open class TranslatorSpec(
    val verbs: IAssertionVerbFactory,
    val testeeFactory: (translationSupplier: ITranslationSupplier, locale: Locale, fallbackLocals: Array<out Locale>) -> ITranslator
) : Spek({

    fun testeeFactory(translationSupplier: ITranslationSupplier, locale: Locale, vararg fallbackLocals: Locale)
        = testeeFactory(translationSupplier, locale, fallbackLocals)

    fun mockTranslationProvider(locale: Locale, translatable: ITranslatable, translation: String): ITranslationSupplier {
        val provider = mock<ITranslationSupplier> {
            on { get(translatable, locale) }.doReturn(translation)
        }
        return provider
    }

    val localeUK = Locale.UK
    val translatableTest = object : ISimpleTranslatable {
        override val value = "test"
        override val name = "test"
    }
    val translatableHello = object : ISimpleTranslatable {
        override val value = "hello"
        override val name = "hello"
    }

    fun SpecBody.checkUsesDefaultOfTranslatable(testee: ITranslator) {
        it("uses ${ITranslatable::class.simpleName}'s ${ITranslatable::getDefault.name}") {
            val result = testee.translate(translatableHello)
            verbs.checkImmediately(result).toBe(translatableHello.value)
        }
    }

    fun SpecBody.checkTranslationSuccessfulForDesiredTranslatable(testee: ITranslator, translation: String, locale: Locale) {
        context("but for the wrong ${ITranslatable::class.simpleName}") {
            it("uses ${ITranslatable::class.simpleName}'s ${ITranslatable::getDefault.name}") {
                val result = testee.translate(translatableTest)
                verbs.checkImmediately(result).toBe(translatableTest.value)
            }
        }

        context("for the desired ${ITranslatable::class.simpleName}") {
            it("uses the translation of Locale $locale") {
                val result = testee.translate(translatableHello)
                verbs.checkImmediately(result).toBe(translation)
            }
        }
    }

    val translationEn = "hi"
    val providerWithEn = mockTranslationProvider(Locale.ENGLISH, translatableHello, translationEn)
    val translationEnUk = "heya"
    val providerWithEnUk = mockTranslationProvider(Locale.UK, translatableHello, translationEnUk)
    val translationEnUs = "howdy"
    val providerWithEnUs = mockTranslationProvider(Locale.US, translatableHello, translationEnUs)

    val translationFr = "bonjour"
    val providerWithFr = mockTranslationProvider(Locale.FRENCH, translatableHello, translationFr)
    val translationFrFr = "salut"
    val providerWithFrFr = mockTranslationProvider(Locale.FRANCE, translatableHello, translationFrFr)

    describe("translating a ${ITranslatable::class.simpleName} to $localeUK without fallbacks") {

        context("no translations provided at all") {
            val testee = testeeFactory(mock<ITranslationSupplier>(), localeUK)
            checkUsesDefaultOfTranslatable(testee)
        }

        context("translation provided for fr_FR") {
            val testee = testeeFactory(providerWithFrFr, localeUK)
            checkUsesDefaultOfTranslatable(testee)
        }

        context("translation provided for en_US") {
            val testee = testeeFactory(providerWithEnUs, localeUK)
            checkUsesDefaultOfTranslatable(testee)
        }

        context("translation provided for en") {
            val testee = testeeFactory(providerWithEn, localeUK)
            checkTranslationSuccessfulForDesiredTranslatable(testee, translationEn, localeUK)
        }

        context("translation provided for en_GB") {
            val testee = testeeFactory(providerWithEnUk, localeUK)
            checkTranslationSuccessfulForDesiredTranslatable(testee, translationEnUk, localeUK)
        }

    }

    describe("translating a ${ITranslatable::class.simpleName} to $localeUK with fallbacks") {

        context("translation provided but for Locale fr_FR without a fallback to it") {
            val testee = testeeFactory(providerWithFrFr, localeUK)
            checkUsesDefaultOfTranslatable(testee)
        }

        context("translation provided in Locale fr_FR but fallback to fr_CA defined") {
            val testee = testeeFactory(providerWithFrFr, localeUK, Locale.CANADA_FRENCH)
            checkUsesDefaultOfTranslatable(testee)
        }

        context("translation provided in Locale fr_FR but fallback to fr defined") {
            val testee = testeeFactory(providerWithFrFr, localeUK, Locale.FRENCH)
            checkUsesDefaultOfTranslatable(testee)
        }

        context("translation provided in Locale fr and fallback to fr_FR defined") {

            context("as first fallback") {
                val testee = testeeFactory(providerWithFr, localeUK, Locale.FRANCE)
                checkTranslationSuccessfulForDesiredTranslatable(testee, translationFr, Locale.FRENCH)
            }
            context("as second fallback") {
                val testee = testeeFactory(providerWithFr, localeUK, Locale.CANADA, Locale.FRANCE)
                checkTranslationSuccessfulForDesiredTranslatable(testee, translationFr, Locale.FRENCH)
            }

            context("as third fallback") {
                val testee = testeeFactory(providerWithFr, localeUK, Locale.CANADA, Locale.GERMAN, Locale.FRANCE)
                checkTranslationSuccessfulForDesiredTranslatable(testee, translationFr, Locale.FRENCH)
            }
        }

        context("translation provided in Locale fr_FR and fallback to fr_FR defined") {

            context("as first fallback") {
                val testee = testeeFactory(providerWithFr, localeUK, Locale.FRENCH)
                checkTranslationSuccessfulForDesiredTranslatable(testee, translationFr, Locale.FRANCE)
            }
            context("as second fallback") {
                val testee = testeeFactory(providerWithFr, localeUK, Locale.CANADA, Locale.FRENCH)
                checkTranslationSuccessfulForDesiredTranslatable(testee, translationFr, Locale.FRANCE)
            }

            context("as third fallback") {
                val testee = testeeFactory(providerWithFr, localeUK, Locale.CANADA, Locale.GERMAN, Locale.FRENCH)
                checkTranslationSuccessfulForDesiredTranslatable(testee, translationFr, Locale.FRANCE)
            }
        }
    }

})
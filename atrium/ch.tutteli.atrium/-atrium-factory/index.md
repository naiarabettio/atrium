[atrium](../../index.md) / [ch.tutteli.atrium](../index.md) / [AtriumFactory](.)

# AtriumFactory

`object AtriumFactory : `[`IAtriumFactory`](../-i-atrium-factory/index.md) [(source)](https://github.com/robstoll/atrium/tree/master/atrium-impl-robstoll/src/main/kotlin/ch/tutteli/atrium/AtriumFactory.kt#L21)

The `abstract factory` of atrium.

It provides factory methods to create:

* [IAssertionPlant](../../ch.tutteli.atrium.creating/-i-assertion-plant/index.md)
* [IAssertionChecker](../../ch.tutteli.atrium.checking/-i-assertion-checker/index.md)
* [IReporter](../../ch.tutteli.atrium.reporting/-i-reporter/index.md)
* [IAssertionMessageFormatter](../../ch.tutteli.atrium.reporting/-i-assertion-message-formatter/index.md)
* [IObjectFormatter](../../ch.tutteli.atrium.reporting/-i-object-formatter/index.md)
* [ThrowableFluent](../../ch.tutteli.atrium.creating/-throwable-fluent/index.md)
* [DownCastBuilder](../../ch.tutteli.atrium.creating/-down-cast-builder/index.md)

### Functions

| [newCheckImmediately](new-check-immediately.md) | `fun <T : Any> newCheckImmediately(assertionVerb: String, subject: T, reporter: `[`IReporter`](../../ch.tutteli.atrium.reporting/-i-reporter/index.md)`): `[`IAssertionPlant`](../../ch.tutteli.atrium.creating/-i-assertion-plant/index.md)`<T>`<br>`fun <T : Any> newCheckImmediately(assertionVerb: String, subject: T, assertionChecker: `[`IAssertionChecker`](../../ch.tutteli.atrium.checking/-i-assertion-checker/index.md)`): `[`IAssertionPlant`](../../ch.tutteli.atrium.creating/-i-assertion-plant/index.md)`<T>`<br>`fun <T : Any> newCheckImmediately(commonFields: `[`CommonFields`](../../ch.tutteli.atrium.creating/-i-assertion-plant-with-common-fields/-common-fields/index.md)`<T>): `[`IAssertionPlant`](../../ch.tutteli.atrium.creating/-i-assertion-plant/index.md)`<T>`<br>Creates an [IAssertionPlant](../../ch.tutteli.atrium.creating/-i-assertion-plant/index.md) which immediately checks added [IAssertion](#)s. |
| [newCheckLazily](new-check-lazily.md) | `fun <T : Any> newCheckLazily(assertionVerb: String, subject: T, reporter: `[`IReporter`](../../ch.tutteli.atrium.reporting/-i-reporter/index.md)`): `[`IAssertionPlant`](../../ch.tutteli.atrium.creating/-i-assertion-plant/index.md)`<T>`<br>`fun <T : Any> newCheckLazily(assertionVerb: String, subject: T, assertionChecker: `[`IAssertionChecker`](../../ch.tutteli.atrium.checking/-i-assertion-checker/index.md)`): `[`IAssertionPlant`](../../ch.tutteli.atrium.creating/-i-assertion-plant/index.md)`<T>`<br>`fun <T : Any> newCheckLazily(commonFields: `[`CommonFields`](../../ch.tutteli.atrium.creating/-i-assertion-plant-with-common-fields/-common-fields/index.md)`<T>): `[`IAssertionPlant`](../../ch.tutteli.atrium.creating/-i-assertion-plant/index.md)`<T>`<br>Creates an [IAssertionPlant](../../ch.tutteli.atrium.creating/-i-assertion-plant/index.md) which does not check the created or
added [IAssertion](#)s until one calls [IAssertionPlant.checkAssertions](../../ch.tutteli.atrium.creating/-i-assertion-plant/check-assertions.md). |
| [newDetailedObjectFormatter](new-detailed-object-formatter.md) | `fun newDetailedObjectFormatter(): `[`IObjectFormatter`](../../ch.tutteli.atrium.reporting/-i-object-formatter/index.md)<br>Creates an [IObjectFormatter](../../ch.tutteli.atrium.reporting/-i-object-formatter/index.md) which represents objects by using their [Object.toString](http://docs.oracle.com/javase/6/docs/api/java/lang/Object.html#toString()) representation
including [Class.name](#) and their [System.identityHashCode](http://docs.oracle.com/javase/6/docs/api/java/lang/System.html#identityHashCode(java.lang.Object)). |
| [newDownCastBuilder](new-down-cast-builder.md) | `fun <TSub : T, T : Any> newDownCastBuilder(description: String, commonFields: `[`CommonFields`](../../ch.tutteli.atrium.creating/-i-assertion-plant-with-common-fields/-common-fields/index.md)`<T?>): `[`DownCastBuilder`](../../ch.tutteli.atrium.creating/-down-cast-builder/index.md)`<T, TSub>`<br>Prepares a down cast; use [DownCastBuilder.cast](../../ch.tutteli.atrium.creating/-down-cast-builder/cast.md) to perform the down cast. |
| [newFeatureAssertionChecker](new-feature-assertion-checker.md) | `fun <T : Any> newFeatureAssertionChecker(subjectPlant: `[`IAssertionPlant`](../../ch.tutteli.atrium.creating/-i-assertion-plant/index.md)`<T>): `[`IAssertionChecker`](../../ch.tutteli.atrium.checking/-i-assertion-checker/index.md)<br>Creates an [IAssertionChecker](../../ch.tutteli.atrium.checking/-i-assertion-checker/index.md) which creates [IFeatureAssertionGroup](#) instead of checking assertions
and delegates this task to the given [subjectPlant](new-feature-assertion-checker.md#ch.tutteli.atrium.AtriumFactory$newFeatureAssertionChecker(ch.tutteli.atrium.creating.IAssertionPlant((ch.tutteli.atrium.AtriumFactory.newFeatureAssertionChecker.T)))/subjectPlant) by adding (see [IAssertionPlant.addAssertion](../../ch.tutteli.atrium.creating/-i-assertion-plant/add-assertion.md)
the created [IFeatureAssertionGroup](#) to it. |
| [newNullable](new-nullable.md) | `fun <T> newNullable(assertionVerb: String, subject: T, reporter: `[`IReporter`](../../ch.tutteli.atrium.reporting/-i-reporter/index.md)`): `[`IAssertionPlantNullable`](../../ch.tutteli.atrium.creating/-i-assertion-plant-nullable/index.md)`<T>`<br>`fun <T> newNullable(assertionVerb: String, subject: T, assertionChecker: `[`IAssertionChecker`](../../ch.tutteli.atrium.checking/-i-assertion-checker/index.md)`): `[`IAssertionPlantNullable`](../../ch.tutteli.atrium.creating/-i-assertion-plant-nullable/index.md)`<T>`<br>`fun <T> newNullable(commonFields: `[`CommonFields`](../../ch.tutteli.atrium.creating/-i-assertion-plant-with-common-fields/-common-fields/index.md)`<T>): `[`IAssertionPlantNullable`](../../ch.tutteli.atrium.creating/-i-assertion-plant-nullable/index.md)`<T>`<br>Creates an [IAssertionPlantNullable](../../ch.tutteli.atrium.creating/-i-assertion-plant-nullable/index.md). |
| [newOnlyFailureReporter](new-only-failure-reporter.md) | `fun newOnlyFailureReporter(assertionMessageFormatter: `[`IAssertionMessageFormatter`](../../ch.tutteli.atrium.reporting/-i-assertion-message-formatter/index.md)`): `[`IReporter`](../../ch.tutteli.atrium.reporting/-i-reporter/index.md)<br>Creates an [IReporter](../../ch.tutteli.atrium.reporting/-i-reporter/index.md) which reports only failing assertions
and uses the given [assertionMessageFormatter](new-only-failure-reporter.md#ch.tutteli.atrium.AtriumFactory$newOnlyFailureReporter(ch.tutteli.atrium.reporting.IAssertionMessageFormatter)/assertionMessageFormatter) to format assertions and messages. |
| [newSameLineAssertionMessageFormatter](new-same-line-assertion-message-formatter.md) | `fun newSameLineAssertionMessageFormatter(objectFormatter: `[`IObjectFormatter`](../../ch.tutteli.atrium.reporting/-i-object-formatter/index.md)`): `[`IAssertionMessageFormatter`](../../ch.tutteli.atrium.reporting/-i-assertion-message-formatter/index.md)<br>Creates an [IAssertionMessageFormatter](../../ch.tutteli.atrium.reporting/-i-assertion-message-formatter/index.md) which puts messages of the form 'a: b' on the same line. |
| [newThrowableFluent](new-throwable-fluent.md) | `fun newThrowableFluent(assertionVerb: String, act: () -> Unit, reporter: `[`IReporter`](../../ch.tutteli.atrium.reporting/-i-reporter/index.md)`): `[`ThrowableFluent`](../../ch.tutteli.atrium.creating/-throwable-fluent/index.md)<br>Creates a [ThrowableFluent](../../ch.tutteli.atrium.creating/-throwable-fluent/index.md) based on the given [assertionVerb](new-throwable-fluent.md#ch.tutteli.atrium.AtriumFactory$newThrowableFluent(kotlin.String, kotlin.Function0((kotlin.Unit)), ch.tutteli.atrium.reporting.IReporter)/assertionVerb) and the [act](new-throwable-fluent.md#ch.tutteli.atrium.AtriumFactory$newThrowableFluent(kotlin.String, kotlin.Function0((kotlin.Unit)), ch.tutteli.atrium.reporting.IReporter)/act) function. |
| [newThrowingAssertionChecker](new-throwing-assertion-checker.md) | `fun newThrowingAssertionChecker(reporter: `[`IReporter`](../../ch.tutteli.atrium.reporting/-i-reporter/index.md)`): `[`IAssertionChecker`](../../ch.tutteli.atrium.checking/-i-assertion-checker/index.md)<br>Creates an [IAssertionChecker](../../ch.tutteli.atrium.checking/-i-assertion-checker/index.md) which throws [AssertionError](http://docs.oracle.com/javase/6/docs/api/java/lang/AssertionError.html)s in case an assertion fails
and uses the given [reporter](new-throwing-assertion-checker.md#ch.tutteli.atrium.AtriumFactory$newThrowingAssertionChecker(ch.tutteli.atrium.reporting.IReporter)/reporter) for reporting. |

### Extension Functions

| [createAssertionsAndCheckThem](../../ch.tutteli.atrium.creating/create-assertions-and-check-them.md) | `fun <T : Any> `[`IAtriumFactory`](../-i-atrium-factory/index.md)`.createAssertionsAndCheckThem(plant: `[`IAssertionPlant`](../../ch.tutteli.atrium.creating/-i-assertion-plant/index.md)`<T>, createAssertions: `[`IAssertionPlant`](../../ch.tutteli.atrium.creating/-i-assertion-plant/index.md)`<T>.() -> Unit): `[`IAssertionPlant`](../../ch.tutteli.atrium.creating/-i-assertion-plant/index.md)`<T>`<br>Uses the given [plant](../../ch.tutteli.atrium.creating/create-assertions-and-check-them.md#ch.tutteli.atrium.creating$createAssertionsAndCheckThem(ch.tutteli.atrium.IAtriumFactory, ch.tutteli.atrium.creating.IAssertionPlant((ch.tutteli.atrium.creating.createAssertionsAndCheckThem.T)), kotlin.Function1((ch.tutteli.atrium.creating.IAssertionPlant((ch.tutteli.atrium.creating.createAssertionsAndCheckThem.T)), kotlin.Unit)))/plant) as receiver of the given [createAssertions](../../ch.tutteli.atrium.creating/create-assertions-and-check-them.md#ch.tutteli.atrium.creating$createAssertionsAndCheckThem(ch.tutteli.atrium.IAtriumFactory, ch.tutteli.atrium.creating.IAssertionPlant((ch.tutteli.atrium.creating.createAssertionsAndCheckThem.T)), kotlin.Function1((ch.tutteli.atrium.creating.IAssertionPlant((ch.tutteli.atrium.creating.createAssertionsAndCheckThem.T)), kotlin.Unit)))/createAssertions) function and
then calls [IAssertionPlant.checkAssertions](../../ch.tutteli.atrium.creating/-i-assertion-plant/check-assertions.md). |
| [newCheckLazilyAtTheEnd](../../ch.tutteli.atrium.creating/new-check-lazily-at-the-end.md) | `fun <T : Any> `[`IAtriumFactory`](../-i-atrium-factory/index.md)`.newCheckLazilyAtTheEnd(assertionVerb: String, subject: T, reporter: `[`IReporter`](../../ch.tutteli.atrium.reporting/-i-reporter/index.md)`, createAssertions: `[`IAssertionPlant`](../../ch.tutteli.atrium.creating/-i-assertion-plant/index.md)`<T>.() -> Unit): `[`IAssertionPlant`](../../ch.tutteli.atrium.creating/-i-assertion-plant/index.md)`<T>`<br>Use this function to create a custom *assertion verb* which lazy evaluates assertions
(see [AtriumFactory.newCheckLazily](new-check-lazily.md)). |

module ch.tutteli.atrium.fluent.en_GB.kotlin_1_3.smoke {
    // test dependencies are usually defined in build.gradle via --patch-module but that's quite cumbersome and I did
    // not get it running in 10 minutes so I am using this, the effect should be the same, the kotlin compiler checks if
    // I am using symbols from packages I do not require etc.

    requires ch.tutteli.atrium.fluent.en_GB;
    requires ch.tutteli.atrium.api.fluent.en_GB.kotlin_1_3;
    requires kotlin.stdlib;
    requires spek.api;
}

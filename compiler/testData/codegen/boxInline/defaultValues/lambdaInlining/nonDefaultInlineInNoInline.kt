// FILE: 1.kt
// LANGUAGE_VERSION: 1.2
// SKIP_INLINE_CHECK_IN: inlineFun$default
package test

inline fun inlineFun(crossinline inlineLambda: () -> String, noinline noInlineLambda: () -> String = { inlineLambda() }): String {
    return noInlineLambda()
}

// FILE: 2.kt
//NO_CHECK_LAMBDA_INLINING
// CHECK_CALLED_IN_SCOPE: function=inlineFun$lambda scope=inlineFun
import test.*

fun box(): String {
    return inlineFun ({ "OK" })
}
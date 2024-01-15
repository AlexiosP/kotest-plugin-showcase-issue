package com.example

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk

class SomeTest: StringSpec() {

    val impl: Impl = mockk()
    val repo = Repository(impl)

    init {
        "should check a" {
            "hello" shouldBe "hello"
        }

        "should be five" {
            every { impl.a() } returns 5
            repo.foo() shouldBe 5
        }
    }
}

class Impl {
    fun a () = 5
}

class Repository(val impl: Impl) {
    fun foo() = impl.a()
}
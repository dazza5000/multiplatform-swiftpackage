package com.chromaticnoise.multiplatformswiftpackage.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.property.Arb
import io.kotest.property.arbitrary.filter
import io.kotest.property.arbitrary.string
import io.kotest.property.forAll

class TargetNameTest : StringSpec({

    "empty name should not be valid" {
        TargetName.of("").shouldBeNull()
    }

    "blank names should not be valid" {
        forAll(Arb.string().filter { it.isBlank() }) { name ->
            TargetName.of(name) == null
        }
    }

    "two instances should be equal if their names are equal" {
        (TargetName.of("equal name") == TargetName.of("equal name"))
            .shouldBeTrue()
    }

    "two instances should not be equal if their names differ" {
        (TargetName.of("some name") == TargetName.of("different name"))
            .shouldBeFalse()
    }
})

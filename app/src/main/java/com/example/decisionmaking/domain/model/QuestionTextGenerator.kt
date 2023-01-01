package com.example.decisionmaking.domain.model

import java.util.Locale

object QuestionTextGenerator {

    fun generateFeatureQuestion(a:FeatureType, b:FeatureType): String = "Which feature is more important,\n\n\n${a.name.format()} or ${b.name.format()}?"

    fun generateItemFeatureQuestion(
        feature: FeatureType,
        bike1: Bike,
        bike2: Bike,
    ): String =
        "What do you prefer,\n\n" +
                "${bike1.name} ${feature.name.format()} ${getFeatureOfBike(feature, bike1)}" +
                " or" +
                " ${bike2.name} ${feature.name.format()} ${getFeatureOfBike(feature, bike2)}?"

    private fun getFeatureOfBike(
        feature: FeatureType,
        bike: Bike
    ) = when (feature) {
        FeatureType.WEIGHT -> bike.weight + "kg"
        FeatureType.PRICE -> bike.price + "$"
        FeatureType.GEARS -> bike.numberOfGears
    }
}

private fun String.format(): String =
    lowercase().capitalize()

private fun String.capitalize(): String =
    replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }


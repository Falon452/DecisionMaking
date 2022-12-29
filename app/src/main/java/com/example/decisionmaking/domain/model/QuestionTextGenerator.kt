package com.example.decisionmaking.domain.model

object QuestionTextGenerator {

    fun generateFeatureQuestion(a:FeatureType, b:FeatureType): String = "Ktora z cech ma dla ciebie wieksze znaczenie ${a.name} czy ${b.name}?"

    fun generateItemFeatureQuestion(
        feature: FeatureType,
        bike1: Bike,
        bike2: Bike,
    ): String =
        "W ktorym z przedmiotow ${feature.name} podoba ci sie bardziej" +
                " z ${bike1.name} ${feature.name}=${getFeatureOfBike(feature, bike1)}" +
                " czy" +
                " z ${bike2.name} ${feature.name}=${getFeatureOfBike(feature, bike2)}?"

    private fun getFeatureOfBike(
        feature: FeatureType,
        bike: Bike
    ) = when (feature) {
        FeatureType.WEIGHT -> bike.weight
        FeatureType.PRICE -> bike.price
        FeatureType.GEARS -> bike.numberOfGears
    }
}
package com.example.decisionmaking.domain.model

object QuestionTextGenerator {
    fun generateFeatureQuestion(a:Features,b:Features):String = "Ktora z cech ma dla ciebie wieksze znaczenie ${a.name} czy ${b.name}?"
    fun generateItemFeatureQuestion(a:Features,bike1:Bike,bike2:Bike):String = "W ktorym z przedmiotow ${a.name} podoba ci sie bardziej ${bike1.name} z ${bike1.name} ${a.name}=${bike1.features[a]} czy z ${bike2.name} ${a.name}=${bike2.features[a]}?"
}
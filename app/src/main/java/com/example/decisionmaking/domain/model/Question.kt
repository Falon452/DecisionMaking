package com.example.decisionmaking.domain.model

data class Question(
    val firstItemId: Int,
    val secondItemId: Int,
    val tableNumber: Int,
    val agentId: Int,
    val questionText: String,
    val questionTarget: QuestionTarget
){
    public fun createAnswer(value:Int): Answer = Answer(value,this.firstItemId,this.secondItemId,this.tableNumber,this.agentId,this.questionTarget)
}

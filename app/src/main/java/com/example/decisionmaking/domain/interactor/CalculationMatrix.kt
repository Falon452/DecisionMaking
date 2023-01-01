package com.example.decisionmaking.domain.interactor

class CalculationMatrix(private val size: Int) {
    private val matrix: Array<Array<Float>> = Array<Array<Float>>(size){Array<Float>(size){1f} }
    private var isNormalized = false
    /*init{
        var initMatrix :MutableList<MutableList<Float>> = mutableListOf();
        for(i in 0..size)
        {
            val row = mutableListOf<Float>();
            for (j in 0..size)
                row.add(1f);
            initMatrix.add(row);
        }
        matrix = initMatrix;
    }*/

    fun changeValue(A:Int,B:Int,value:Float)
    {
        matrix[A][B] = value
        if (value != 0f) {
            matrix[B][A] = 1 / value
        } else {
            matrix[B][A] = 10f
        }
        isNormalized = false
    }
    private fun normalize()
    {
        for(col in 0 until size)
        {
            var sum = 0f
            for(row in 0 until size)
                sum+= matrix[row][col]

            for(row in 0 until size)
                matrix[row][col]/=sum
        }
        isNormalized=true
    }
    fun extractPriorities() : List<Float>
    {
        if(!isNormalized)
            normalize()

        val priorities = mutableListOf<Float>();
        for(row in matrix)
        {
            priorities.add(row.sum()/matrix.size)
        }
        return priorities
    }

    override fun toString(): String {
        var out ="\n["
        for(row in matrix) {
            out += "["
            for (item in row)
                out += "$item, "
            out += "]\n"
        }
        out+="]\n"
        return out
    }

}
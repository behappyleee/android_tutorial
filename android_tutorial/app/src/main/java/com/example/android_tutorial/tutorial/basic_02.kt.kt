package com.example.android_tutorial.tutorial

fun main() {

    // 조건식

}

fun compare(a  : Int, b : Int): Int {
    if(a < b) {
        return a;
    } else {
        return b;
    }
}

// Kotlin 에서는 비교적 간단하게 표현이 가능함 (kotlin 에는 삼항 연산자가 존재하지 않음
fun compare_2(a: Int, b: Int) = if(a>b) a else b;

fun checkNum(score: Int) {
    // kotlin 에서는 when 문법이 많이 사용 도됨
    when(score) {
        0 -> println("this is 0");
        1 -> println("this is 1");
        2,3 -> println("this is 2 or 3");       // 복수 정답도 인정 이 됨
        else -> println("this is else !!!");    // 아무것도 만족하지 않을 시 else 를 사용
    }

    // expression 사용시 꼭 else 를 작성을 해주어야 함
    var b : Int = when(score) {
        1 -> 1
        2 -> 2
        else -> 3
    }

    when(score) {
        in 90 .. 100 -> println("You are genius")
        in 10.. 80 -> println("You bad!")
        else -> println("okay")
    }



}






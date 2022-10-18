package com.example.android_tutorial.tutorial

// Kotlin 이 JAVA 랑 다른점은 Class 이름이랑 파일 이름이랑 같지 않아도 되고 클래스가 여러개 있어도 됨
// 하지만 Java 처럼 Class 이름이랑 맞추는 것을 추천

fun main() {
    // Java 와 달리 new 키워드가 필요가 없음
    // 객체 생성시 파라미터 안넣어주면 에러 발생 (Constructor 에 Parameter 가 존재하므로)
    val human = Human("미현");
    human.eatingCake();

    val name = "joyce";
    println("This is Human's name is ${human.name}");
    


}

// 객체를 생성시에 값을 넣어주고 싶을 시 Constructor 를 이용
// 문법이 자바와 다름
class Human constructor(name: String){
    val name = "joyce";
    fun eatingCake() {
        println("This is so yummy ~~~~");
    }
}
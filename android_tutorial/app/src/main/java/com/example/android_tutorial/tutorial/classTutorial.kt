package com.example.android_tutorial.tutorial

// Kotlin 이 JAVA 랑 다른점은 Class 이름이랑 파일 이름이랑 같지 않아도 되고 클래스가 여러개 있어도 됨
// 하지만 Java 처럼 Class 이름이랑 맞추는 것을 추천

fun main() {
    // Java 와 달리 new 키워드가 필요가 없음
    // 객체 생성시 파라미터 안넣어주면 에러 발생 (Constructor 에 Parameter 가 존재하므로)
    // val human = Human("미현");

    // Default 값 존재 시 안넣어주어 됨
    val human = Human();
    human.eatingCake();
    println("This is Human's Name : ${human.name}");
    
    // 부 생성자에 age 값을 넣어줄 수 있음
    val humanTest = Human("NameTest", 23);


}

// 객체를 생성시에 값을 넣어주고 싶을 시 Constructor 를 이용
// 문법이 자바와 다름
// class Human constructor(val name: String){
// Default 값도 줄 수 있음 객체 생성시에 값을 안넣어주어도됨
open class Human constructor(val name: String = "Annoymous") {
    // 부 생성자도 생성이 가능   (하지만 위에 생성자 값을 항상 받아와야 함)
    // 자바에서는 Overrloading 개념이랑 비슷 (생성자지만 파라미터가 다른 경우..)
    constructor(name: String, age : Int) : this(name) {
        println("My Name is ${name}, Age : ${age}");
    }

    // init 을 사용시 해당 클래스가 처음 생성 시 어떤 값을 초기화 설정해줄 지 가능
    // init 을 먼저 실행 그 다음 constructor 블럭이 실행이 됨
    init {
        println("New Human has been born !!!");
    }
    // val name = "joyce";
    fun eatingCake() {
        println("This is so yummy ~~~~");
    }
    open fun singASong() {
        println("Sing A Song ~~~~~~ !!!!");
    }
}

// Kotlin 도 Java 와 마찬가지로 Class 하나만 상속이 가능 !!!
// Kotlin 에 클래스는 default 로 final 클래스므로 상속원하는 클래스에 open 키워드에 적아주기
// Korean 클래스는 Human 클래스를 상속 받음 (class 에 open 키워드가 있어야 상속이 가능 kotlin 은 기본적으로 final 임)
class Korean : Human() {
    // overrdie 원하는 메서드가 있을 시 해당 메서드에 open 을 적어주어야 함
    override fun singASong() {
        super.singASong();  // Human 즉 부모클래스에 singASong 메서드 사용이 가능
        println("Korean Class Sing A Song ~~~~ !");
        // 부모의 프로퍼티도 사용이 가능
        println("My Name is ~~~  : ${name}")
    }


}
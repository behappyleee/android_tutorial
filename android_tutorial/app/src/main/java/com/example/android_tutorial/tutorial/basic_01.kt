package com.example.android_tutorial.tutorial

// Kotilin Entry 함수
// kotlin 함수 작성 무엇을 Return 하 든 항상 앞에는 fun 함수 앞에는
fun main() {
    // 3. Kotlin 에는 String templates 이 있음
    val name = "joyce";
    val lastName = "lastName";
    // 변수를 출력 원할 시에는 달러 표시를 사용 하기
    // 한가지 주의 점에는 달러만 표시 할 때는 반드시 띄워쓰기를 해주 기
    // 만약 띄워쓰기를 해주지 않을 시 항상 대괄호를 사용 println("My Name is ${name} s23");
    // 대괄호를 왠만하면 사용을 하기 (사용이 필수는 아님)
    println("My Name is ${name + lastName} s23");
    // 만약 달러표시를 원할 시에는 백 슬래쉬를 사용 하기 !
    println("this is \$a")

    // 4. 조건 식


    helloWorld();
    println(add(4,5));

}

// 1. 함수
// 2. 리턴형이 없을 시 Unit 써주기 (java void 같은것) - 인텔리제이에서 회색은 안써도 되는 것임
fun helloWorld() : Unit {
    println("Hello World !");
}

// 변수 이름 써주고 : 변수 타입 작성 하고 Return 타입 명시
fun add(a: Int, b: Int) :Int {
    return a+b;
}
// var (variable) :
// val (value) : 바뀌지 않는 값

fun hi() {
    val a : Int = 10;   // 변할 수 없는 값
    // a = 20; // ERR 발생 (val 은 값이 변할 수 없으므로)
    var b : Int = 9;    // 변하는 값
    b = 30;
    var c = 30;     // Kotlin 은 Type 을 써주지 않아도 Type 을 알아서 지정해 줌 (코틀린은 Int 라고 생각함)
    val d = 100;    // var 와 val 은 꼭 명시 해주기
    var name = "john";

    // 만약 바로 할당해주지 않을 시 (꼭 타입을 명시를 해주어야 함)
    var e : String;

}

class KotlinGrammar {
    // Kotlin 기본 문법
    // Kotilin Entry 함수

}
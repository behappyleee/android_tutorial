package com.example.android_tutorial.tutorial

// Lamda
// 람다식은 우리가 마치 value 처럼 다룰 수 있는 익명 함수
// 1) 메서드의 파라미터로 넘겨줄 수 있음 (value 처럼 사용을 하므로)
// 2) return 값으로 사용할 수 가 있다.

// 람다의 기본 정의
// val lamdaName : Type = {argumentList -> CodeBody}
val square : (Int) -> (Int) = { number -> number * number}
val nameAge : (String, Int) -> String = {
    name : String, age:Int -> "my Name is ${name} I am ${age}"
}

// 확장 함수
val pizzaIsGreat : String.() -> String = {
    this + "Pizza is the best !"
}

fun extendString(name: String, age: Int) : String {
    // Parameter 는 딱 하나
    // this 는 현재 Object 를 가르킴
    val introduceMySelf : String.(Int) -> String = {
        "I am ${this} and ${it} yours Old"
    }
    return name.introduceMySelf(age);
}

// 람다의 Return (parameter 는 여러개 존재 할수도 있기에 항상 괄호를 작성해 주어야 함)
val calculateGrade : (Int) -> String = {
    when(it) {
        in 0..40 -> "fail"
        in 41..70 -> "pass"
        in 71..100 -> "perfect"
        else -> "Error"
    }
}

// 람다를 표현하는 2가지 방법
fun invokeLamda (lamda: (Double) -> Boolean) : Boolean {
    return lamda(5.243);
}

fun main () {
    println(square(4));
    println(nameAge("lee" , 30));
    val a = "joyce said";   // Type - String
    val b = "mac said";
    println(a.pizzaIsGreat());  // 확장 함수는 이렇게 사용
    print(b.pizzaIsGreat());

    println(extendString("Lee Test", 27));
    println(calculateGrade(320));

    val lamdas : (Double) -> Boolean = {number : Double ->
        number == 4.2314;
    }
    // False 를 출력
    println("LAMDAS : " + invokeLamda(lamdas));
    println("SECOND LAMDA TEST : " + invokeLamda({ it > 3.221}));

    // parameter 가 마지막에 존재 시 소괄호를 생략을 가능
    invokeLamda{ it > 3.52 };

}







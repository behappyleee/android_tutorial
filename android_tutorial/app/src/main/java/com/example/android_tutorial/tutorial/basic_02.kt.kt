package com.example.android_tutorial.tutorial

fun main() {

    // 조건식
    // checkNum(1);
    
    // 반복문
    forAndWhile();
}

fun compare(a  : Int, b : Int): Int {
    if(a < b) {
        return a;
    } else {
        return b;
    }
}

// Kotlin 에서는 비교적 간단하게 표현이 가능함 (kotlin 에는 삼항 연산자가 존재하지 않음)
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
    println("b : ${b}");
    when(score) {
        in 90 .. 100 -> println("You are genius")
        in 10.. 80 -> println("You bad!")
        else -> println("okay")
    }
}

// Expression vs Statement
// Expression -> 어떤 값을 만들면 표현식 (Expression)
// ex) when 같은 것은 값을 만드는 것은 아니므로 statement 임
// 코틀린에 모든 함수는 Expression 임 (모든 함수는 Unit 을리턴 하므로 (리턴값이 없을 경우에)
// 코틀린은 리턴값이 없을 때 는 Unit 을 반환, kotlin 은 expression 및 statement 로 사용이 가능

// Java 같은 경우는 void 가 있으므로 리턴 값이 없는 것은 statement 임
// Statement -> 이렇게 명령하는 문장 같은 성격
// Array vs List (Array 는 정해진 사이즈가 있음, List 는 정해진 크기가 없음)
// Array

// List 1 Immutable (수정이 불가능한 리스트) , List 2, MutableList (수정이 가능한 리스트)

fun array() {
    val array :Array<Int> = arrayOf(1,2,3);
    val list : List<Int> = listOf(1,2,3);

    // 타입이 섞여있을 때 에는 Any 로 타입 넣어 줌
    val array2 : Array<Any> = arrayOf(1, "3", 3.16);
    val list2 : List<Any> = listOf(1,"d", 11);

    array[0] = 3;   // 값을 바꾸는 것은 가능
    // list[2] = 7;    // 리스트는 값을 바꾸지 못 함
    // list.add(9);    // List 는 Interface 이므로 값을 추가하지 못함 ArrayList 사용
    
    // List 는 인터페이스임 값을 가져올 수 는 있음
    var result : Int = list.get(0);
    
    // MutableList 만 값을 바꾸는 것이 가능
    // 주소 값은 바뀌지 않으므로 val 로 선언을 하였지만 값 추가 및 변경이 가능
    val arrayList : ArrayList<Int> = arrayListOf(1,2,3);
    arrayList.add(10);
    // 재 선언은 주소값이 바뀌므로 재 선언은 불가
    // arrayList = arrayListOf(7,8,9);
}

// 반복문 for / while

fun forAndWhile() {
    val students  : ArrayList<String> = arrayListOf("joyce", "james", "jennifer");
    for(name: String in students) {
        println("this is name : " + name);
    }

    var sum : Int = 0;
    for(i in  1..10) {
        sum += i;
    }

    println("TOTAL SUM : " + sum);

    // step 을 2씩 1 3 5 7 9 ...
    for(i in 1..10 step 2) {
    }
    // until 은 포함 안하는 값
    for(i in 1 until 100) {
    }

    var index = 0;
    while(index < 10) {
        println("CURRENT INDEX : " + index);
        index++;
    }

    for((index: Int, name: String) in students.withIndex()) {
        println("${index + 1} 번 쨰 학생 : ${name}");
    }
}

// NonNull 과 Nullable 이 있음 (Java 와 Kotlin 에 가장 큰 차이)
fun nullCheck() {
    // NPE : Null Pointer Exception
    // 이러면 기본적으로 NonNull Type 임
    var name : String = "joyce";
    
    // Error 발생 NonNull Type 에 null 대입
    // var nullableName :String = null;
    
    // 물음표를 추가해 주면 Nullable 타입으로 사용이 가능
    var nullableName : String? = null;

    var nameInUpperCase = name.toUpperCase();

    // Err 발생 왜냐면 nullableName 이 널인지 아닌 지 몰라서 API 사용이 불가
    var nullNameInUpperCase = nullableName.toUpperCase();

    // 물음표를 추가할 시 해당에러 해결이 가능
    var nullNameInUpperCase2 = nullableName?.toUpperCase();

    

}









package com.example.android_tutorial.tutorial

// 자바의 static 대신 사용 되는 것이며
// 정적인 메서드 생성 시 사용

// 다른데서 사용하지 못하도록 private을 사용
class Book private constructor(val id : Int, val name : String ) {
    // companion Object 로 선언
    // Companion Object 이름 작성도 가능
    companion object BookFactory : IdProvider{
        // property 작성도 가능
        val myBook = "My Book Name";
        fun create() : Book = Book(0, myBook);
        override fun getId(): Int {
            return 77777;
        }
    }
}

interface IdProvider {
    fun getId() : Int;
}


fun main() {
    // 아래처럼 객체 생성은 불가
    // val book = Book();

    // 아래처럼 생성 하여야 함
    val book = Book.create();

    // 아래처럼 사용이 가능
    println("${book.id}    ${book.name}");

    val bookId = Book.create();

}
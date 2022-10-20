package com.example.android_tutorial.tutorial

// Data Class 변수는 Property 처럼 사용이 가능
data class Ticket
    (val companyName : String, val name :String, var date: String, var seatNumber : Int)

class TicketNormal(val companyName : String, val name :String, var date: String, var seatNumber : Int)


// Data 클래스를 사용시 아래 메서드가 자동으로 생성이 됨
// toString(), hashCode(), equals(), copy()

fun main() {
    // Java 로 만들려면 복잡해 지지만 Kotlin 은 굉장히 간단하게 사용이 가능
    val ticketA = Ticket("Korean Air", "joyce", "2022-07-30", 14);
    val ticketB = TicketNormal("Korean Air", "joyce", "2022-07-30", 14);

    // 데이터가 출력
    println("TICKET A : " + ticketA)
    // 주소값이 출력 이됨
    println("TICKET A : " + ticketB)
}

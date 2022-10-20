package com.example.android_tutorial.tutorial

object CarFactory {
    // Object 는 다른 클래스와 다른점은 CarFacotry 라는 객체를 딱 한번만 생성이됨
    // Singleton Pattern 이다. (불필요하게 메모리가 사용 되는 것을 막을 수 있음)
    val cars = mutableListOf<Car>();
    fun makeCar(horsePower: Int) : Car {
        // car DataClass 객체를 생성
        val car = Car(horsePower);
        cars.add(car);
        // car 를 반환
        return car;
    }
}

data class Car (val horsePower : Int)

fun main() {
    val carA :Car = CarFactory.makeCar(10);
    val carB :Car = CarFactory.makeCar(200);

    println();
    println();
}
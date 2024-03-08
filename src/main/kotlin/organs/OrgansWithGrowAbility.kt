package org.example.organs

import org.example.*
import org.example.interfaces.InterfaceOfBaseOrganWithGrowAbility

// ++++++++++ BEGIN ++++++++++
// При створенні нового органу обов'язково
// 1. додати його до переліку органів відповідного классу!!!
// 2. додати його параметри до переліку параметрів органів відповідного классу!!!
// 3. Тулуби додавати но переліку тулубів, а параметри до параметрів органів які мають можливість вирощувати!!!
// ----------- END -----------

// ++++++++++ BEGIN ++++++++++
// Тулуб Body() та його підкласи не додавати в перелік органів!
// тулуб не має органа-власника і не може бути вирощенним !!!
// ----------- END -----------

// ===========================
// +++++ Звичайні органи +++++
// ===========================

// Тулуби додавати в listOfBodiesParameters !!!
open class Body(organParams: ParamsOfBaseOrganThatCanNotBeGrowedWithGrowAbility=ParamsOfBaseOrganThatCanNotBeGrowedWithGrowAbility.BODY) : BaseOrganThatCanNotBeGrowedWithGrowAbility(organParams) {
}

open class Leg(organParams: ParamsOfBaseOrganThatCanBeGrowedWithGrowAbility=ParamsOfBaseOrganThatCanBeGrowedWithGrowAbility.LEG) : BaseOrganThatCanBeGrowedWithGrowAbility(organParams) {
    private fun doStep() {
        println("Нога зробила крок (доробити напрямок і переміщення організма по координатах)")
    }
}

open class Hand(organParams: ParamsOfBaseOrganThatCanBeGrowedWithGrowAbility=ParamsOfBaseOrganThatCanBeGrowedWithGrowAbility.HAND) : BaseOrganThatCanBeGrowedWithGrowAbility(organParams) {
    fun take() {
        println("Я схопила тебе! Тобі не вирватись!")
    }
}

open class Head(organParams: ParamsOfBaseOrganThatCanBeGrowedWithGrowAbility=ParamsOfBaseOrganThatCanBeGrowedWithGrowAbility.HEAD) : BaseOrganThatCanBeGrowedWithGrowAbility(organParams) {
    private fun processInformation() {
        println("Обробляю інформацію (доробити від кого і в залежності від результату обрати команду органу)")
    }
}

open class Mouth(organParams: ParamsOfBaseOrganThatCanBeGrowedWithGrowAbility=ParamsOfBaseOrganThatCanBeGrowedWithGrowAbility.MOUTH) : BaseOrganThatCanBeGrowedWithGrowAbility(organParams) {
    private fun eat() {
        println("Зжераю *об'єкт*")
    }
}
// ===========================
// ----- Звичайні органи -----
// ===========================



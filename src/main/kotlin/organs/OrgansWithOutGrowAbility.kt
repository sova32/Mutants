package org.example.organs

import org.example.BaseOrganThatCanBeGrowedWithOutGrowAbility
import org.example.ParamsOfBaseOrganThatCanBeGrowedWithOutGrowAbility

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
open class Ear(organParams: ParamsOfBaseOrganThatCanBeGrowedWithOutGrowAbility=ParamsOfBaseOrganThatCanBeGrowedWithOutGrowAbility.EAR) : BaseOrganThatCanBeGrowedWithOutGrowAbility(organParams) {
    private fun hear() {
        println("Я чую тебе! Ти десь поруч!")
    }
}

open class Nose(organParams: ParamsOfBaseOrganThatCanBeGrowedWithOutGrowAbility=ParamsOfBaseOrganThatCanBeGrowedWithOutGrowAbility.NOSE) : BaseOrganThatCanBeGrowedWithOutGrowAbility(organParams) {
    private fun sniff() {
        println("Я відчуваю твій запах...")
    }
}

open class Eye(organParams: ParamsOfBaseOrganThatCanBeGrowedWithOutGrowAbility=ParamsOfBaseOrganThatCanBeGrowedWithOutGrowAbility.EYE) : BaseOrganThatCanBeGrowedWithOutGrowAbility(organParams) {
    private fun searchByLooking() {
        println("Я тебе бачу!")
    }
}
// ===========================
// ----- Звичайні органи -----
// ===========================




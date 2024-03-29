package org.example

import org.example.interfaces.*
import org.example.organs.*

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

// =======================================
// +++++ Параметри та списки органів +++++
// =======================================
enum class ParamsOfBaseOrganThatCanBeGrowedWithOutGrowAbility(
    override val organName: String,
    override val basePower: Int,
) : InterfaceOfBaseOrganParamsWithOutGrowAbility {
    EAR(organName = "Вухо", basePower = 15),
    NOSE(organName = "Ніс", basePower = 15),
    EYE(organName = "Око", basePower = 10),
}

enum class ParamsOfBaseOrganThatCanBeGrowedWithGrowAbility(
    override val organName: String,
    override val basePower: Int,
    override val maxOrgansCount: Int
) : InterfaceOfBaseOrganParamsWithGrowAbility {
    LEG(organName = "Нога", basePower = 40, maxOrgansCount = 2),
    HAND(organName = "Рука", basePower = 30, maxOrgansCount = 2),
    HEAD(organName = "Голова", basePower = 25, maxOrgansCount = 6),
    MOUTH(organName = "Рот", basePower = 20, maxOrgansCount = 1),
}

enum class ParamsOfBaseOrganThatCanNotBeGrowedWithGrowAbility(
    override val organName: String,
    override val basePower: Int,
    override val maxOrgansCount: Int
) : InterfaceOfBaseOrganParamsWithGrowAbility {
    BODY(organName = "Тулуб", basePower = 50, maxOrgansCount = 16),
}

val listOfOrgansWithOutGrowAbility = mapOf(
    "EAR" to Pair(::Ear, ParamsOfBaseOrganThatCanBeGrowedWithOutGrowAbility.EAR),
    "NOSE" to Pair(::Nose, ParamsOfBaseOrganThatCanBeGrowedWithOutGrowAbility.NOSE),
    "EYE" to Pair(::Eye, ParamsOfBaseOrganThatCanBeGrowedWithOutGrowAbility.EYE),
)
val listOfOrgansWithGrowAbility
// Тулуби додавати в listOfBodiesParameters !!!
        = mapOf(
    "LEG" to Pair(::Leg, ParamsOfBaseOrganThatCanBeGrowedWithGrowAbility.LEG),
    "HAND" to Pair(::Hand, ParamsOfBaseOrganThatCanBeGrowedWithGrowAbility.HAND),
    "HEAD" to Pair(::Head, ParamsOfBaseOrganThatCanBeGrowedWithGrowAbility.HEAD),
    "MOUTH" to Pair(::Mouth, ParamsOfBaseOrganThatCanBeGrowedWithGrowAbility.MOUTH),
)
val listOfBodiesParameters = mapOf(
// Тулуби додавати в цей список ( listOfBodiesParameters )!!!
    "BODY" to Pair(::Body, ParamsOfBaseOrganThatCanNotBeGrowedWithGrowAbility.BODY),
)
// ======================================
// ----- Параметри та списки органів -----
// =======================================
abstract class BaseOrgan(organParams: InterfaceOfBaseOrganParams) : InterfaceOfBaseOrgan {
    override val organName: String = organParams.organName
    override val basePower: Int = organParams.basePower
}

abstract class BaseOrganWithOutGrowAbility(organParams: InterfaceOfBaseOrganParamsWithOutGrowAbility) :BaseOrgan(organParams), InterfaceOfBaseOrganWithOutGrowAbility {
}

abstract class BaseOrganWithGrowAbility(organParams: InterfaceOfBaseOrganParamsWithGrowAbility) : BaseOrgan(organParams), InterfaceOfBaseOrganWithGrowAbility {
    override val organs: MutableList<InterfaceOfBaseOrganThatCanBeGrowed> = mutableListOf()
    override val maxOrgansCount = organParams.maxOrgansCount
}

// Око, Ніс, Вухо
abstract class BaseOrganThatCanBeGrowedWithOutGrowAbility(organParams: InterfaceOfBaseOrganParamsWithOutGrowAbility) :
    InterfaceOfBaseOrganThatCanBeGrowed, BaseOrganWithOutGrowAbility(organParams){
    override val owner: InterfaceOfBaseOrganWithGrowAbility
        get() = TODO("Not yet implemented")
}

// Нога Рука, Рот, Голова
abstract class BaseOrganThatCanBeGrowedWithGrowAbility(organParams: InterfaceOfBaseOrganParamsWithGrowAbility) :
    InterfaceOfBaseOrganThatCanBeGrowed, BaseOrganWithGrowAbility(organParams){
    override val owner: InterfaceOfBaseOrganWithGrowAbility
        get() = TODO("Not yet implemented")
}

// Тулуб
abstract class BaseOrganThatCanNotBeGrowedWithGrowAbility(organParams: InterfaceOfBaseOrganParamsWithGrowAbility) :
    InterfaceOfBaseOrganThatCanNotBeGrowed, BaseOrganWithGrowAbility(organParams){
}

fun main() {

}
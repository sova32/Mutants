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

abstract class TopLevelBaseOrgan(organParams: InterfaceOfBaseOrganParams) : InterfaceOfBaseOrgan {
    override val organName: String = organParams.organName
    override val basePower: Int = organParams.basePower
}

abstract class BaseOrganThatCanNotBeGrowed(organParams: InterfaceOfBaseOrganParams):
    TopLevelBaseOrgan(organParams)

abstract class BaseOrganThatCanBeGrowed(organParams: InterfaceOfBaseOrganParams):
    TopLevelBaseOrgan(organParams), InterfaceOfBaseOrganThatCanBeGrowed {
    override val owner: InterfaceOfBaseOrganWithGrowAbility = TODO()
}
// Око, Ніс, Вухо
abstract class BaseOrganThatCanBeGrowedWithOutGrowAbility(organParams: ParamsOfBaseOrganThatCanBeGrowedWithOutGrowAbility) :
    BaseOrganThatCanBeGrowed(organParams), InterfaceOfBaseOrganWithOutGrowAbility{
}

// Нога Рука, Рот, Голова
abstract class BaseOrganThatCanBeGrowedWithGrowAbility(organParams: ParamsOfBaseOrganThatCanBeGrowedWithGrowAbility) :
    BaseOrganThatCanBeGrowed(organParams), InterfaceOfBaseOrganWithGrowAbility {
    override val maxOrgansCount = organParams.maxOrgansCount
    override val organs: MutableList<BaseOrganThatCanBeGrowed> = mutableListOf()
    override fun growOrgan() {
        TODO("Додає вирощений орган в organs" +
                "Додає себе у owner вирощеного органу")
    }
}

// Тулуб
abstract class BaseOrganThatCanNotBeGrowedWithGrowAbility(organParams: ParamsOfBaseOrganThatCanNotBeGrowedWithGrowAbility) :
    BaseOrganThatCanNotBeGrowed(organParams), InterfaceOfBaseOrganWithGrowAbility {
    override val maxOrgansCount = organParams.maxOrgansCount
    override val organs: MutableList<BaseOrganThatCanBeGrowed> = mutableListOf()
    override fun growOrgan() {
        TODO("Додає вирощений орган в organs" +
                "Додає себе у owner вирощеного органу")    }
}

// Не питайте, наприклад, чому на нозі може вирости око. Це така мутація. А роблю я це для того щоб навчитись вирішувати для мене одного складні задачі і
// навчитись правильно використовувати інтерфейси, абстрактні та відкриті класи.
// Знаю що для інших це єрунда. Один я дибіл вже тиждень мучаюсь.
// Треба щоб будь який орган із можливістю вирощувати органи, а саме: Тулуб, Нога Рука, Рот, Голова, тобто які реалізують інтерфейс
// InterfaceOfBaseOrganWithGrowAbility могли приймати лише ті органи які можна виростити, а саме Око, Ніс, Вухо, Нога Рука, Рот, Голова,
// тобто які реалізують інтерфейс InterfaceOfBaseOrganThatCanBeGrowed (чи наслідковуються від BaseOrganThatCanBeGrowed)
// Короче треба щоб будь який клас який може відрощувати органи, тобто реалізує інтерфейс InterfaceOfBaseOrganWithGrowAbility міг приймати одне з:
// 1. будь який клас який може вирости BaseOrganThatCanBeGrowed
// 2. який клас який реалізує інтерфейс InterfaceOfBaseOrganThatCanBeGrowed
// Що грамотніше вибрати 1 чи 2 ?
// Пробував використати генеріки але нічого не вийшло в мене.
// Треба щоб не програма на мене матюкалась, а сам компілятор.
// Як мені позбавитись повторення override val organs: MutableList<BaseOrganThatCanBeGrowed> = mutableListOf() та override fun growOrgan() {...} у
// BaseOrganThatCanBeGrowedWithGrowAbility та BaseOrganThatCanNotBeGrowedWithGrowAbility ?
// Для цього мені треба зробити клас BaseOrganWithGrowAbility і від нього наслідуватись, але тоді я не зможу наслідуватись від класу BaseOrganThatCanBeGrowed
// і мені прийдеться в двох класах 2 рази повторювати override val owner: InterfaceOfBaseOrganWithGrowAbility бо неможна наслідуватись від двох класів одночасно

// Чому я такий тупорилий?
// Дупой чую що в мене тут усе через дупу
// На скіки я тупорилий раз не можу вирішити цю елементарну задачу?
// Може мені взагалі закинути це програмування і йти на будівництво цеглу тягати?

fun main() {

}

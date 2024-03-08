package org.example.interfaces

import org.example.*

// =================================
// +++++ Інтерфейси параметрів +++++
// =================================
interface InterfaceOfBaseOrganParams {
    val organName: String
    val basePower: Int
}

interface InterfaceOfBaseOrganParamsWithOutGrowAbility : InterfaceOfBaseOrganParams

interface InterfaceOfBaseOrganParamsWithGrowAbility : InterfaceOfBaseOrganParams {
    val maxOrgansCount: Int
}
// =================================
// ----- Інтерфейси параметрів -----
// =================================

// ==============================
// +++++ Інтерфейси органів +++++
// ==============================
interface InterfaceOfBaseOrgan {
    val organName: String
    val basePower: Int
}

interface InterfaceOfBaseOrganThatCanBeGrowed : InterfaceOfBaseOrgan {
    val owner: InterfaceOfBaseOrganWithGrowAbility
}

interface InterfaceOfBaseOrganThatCanNotBeGrowed : InterfaceOfBaseOrgan {
}

interface InterfaceOfBaseOrganWithOutGrowAbility : InterfaceOfBaseOrgan {
}

interface InterfaceOfBaseOrganWithGrowAbility : InterfaceOfBaseOrgan {
    val maxOrgansCount: Int
    val organs: MutableList<InterfaceOfBaseOrganThatCanBeGrowed>
}


// ==============================
// ----- Інтерфейси органів -----
// ==============================



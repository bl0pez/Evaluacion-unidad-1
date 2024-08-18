package com.evaluacion1

class EmpleadoRegular(sueldoBruto: Double): Empleado(sueldoBruto) {
    override fun calcularLiquido(): Double {
        val sueldo = sueldoBruto * 0.20;
        return sueldoBruto - sueldo;
    }
}
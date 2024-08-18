package com.evaluacion1

class EmpleadoHonorarios(sueldoBruto: Double): Empleado(sueldoBruto) {
    override fun calcularLiquido(): Double {
        val sueldo = sueldoBruto * 0.13;
        return sueldoBruto - sueldo;
    }
}
package com.evaluacion1

class EmpleadoHonorarios(sueldoBruto: Double): Empleado(sueldoBruto) {
    override fun calcularLiquido(): Double {
        return sueldoBruto * 0.87
    }
}
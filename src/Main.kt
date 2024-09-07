import kotlin.system.exitProcess

fun main() {
    val shopOne = Shop("Кострома", true, 0,  1)
    val shopTwo = Shop("Ярославль", false, 0,  2)



    println("Добро пожаловать в интернет магазин \"Buy a phone, please\"")
    while (true) {
        println(
            "Выберите город:\n" +
                    "1. ${shopOne.city}\n" +
                    "2. ${shopTwo.city}\n" +

                    "Завершить работу, введите \"0\""
        )
        when (readln()) {
            "1" -> {
                getLine("-")
                println("Выбран ${shopOne.city}\n")
                shopOne.checkPhone(shopOne.base)


            }

            "2" -> {
                getLine("-")
                println("Выбран ${shopTwo.city}\n")
                shopTwo.checkPhone(shopTwo.base)


            }

            "0" -> {
                goodbye()
            }

            else -> println("Введено неверное значение!\nПопробуйте еще раз\n\n")
        }
    }
}


fun goodbye() {
    println("Завершить работу?\n1. Да\n2. Нет")
    when (readln()) {
        "1" -> {
            getLine("-")
            println("Выход")
            exitProcess(-1)
        }

        "2" -> println()
        else -> println("Введено неверное значение!\nПопробуйте еще раз\n\n")
    }

}

fun getLine(sample: String) {
    for (i in 0..99) {
        print(sample)
    }
    println()
}

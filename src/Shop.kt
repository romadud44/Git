class Shop(
    val city: String,
    private val repair: Boolean,
    private var countBuyPhones: Int,
    val base: Int
) : Services {

    private val phones: MutableMap<Int, MutableList<Phone>> = mutableMapOf(
        1 to mutableListOf(
            Phone("iPhone", 105_000, 0, 0),
            Phone("Samsung", 92_000, 0, 0),
            Phone("NothingPhone", 71_000, 0, 0)
        ),
        2 to mutableListOf(
            Phone("iPhone", 100_000, 0, 0),
            Phone("Samsung", 90_000, 0, 0),
            Phone("NothingPhone", 70_000, 0, 0)
        )
    )

    override fun buyPhone(base: Int) {
        this.countBuyPhones++
        println("Выберите телефон:")


        var index = 0
        phones[base]?.forEach { i ->
            println("${++index}. ${i.name}, Цена:${i.price} ")
        }
        println("4. Показать статистику магазина")
        when (readln()) {
            "1" -> {
                val phoneIt = phones[base]?.get(0)
                val priceIt = phones[base]?.get(0)?.price
                phones[base]?.get(0)?.let { it.profit += it.price }
                phones[base]?.get(0)?.let { it.count += 1 }


                println("\nКуплен \"${phoneIt?.name}\", по цене $priceIt}\n")

            }

            "2" -> {
                val phoneIt = phones[base]?.get(1)
                val priceIt = phones[base]?.get(1)?.price
                phones[base]?.get(1)?.let { it.profit += it.price }
                phones[base]?.get(1)?.let { it.count += 1 }

                println("\nКуплен \"${phoneIt?.name}\", по цене $priceIt}\n")
            }

            "3" -> {
                val phoneIt = phones[base]?.get(1)
                val priceIt = phones[base]?.get(1)?.price
                phones[base]?.get(2)?.let { it.profit += it.price }
                phones[base]?.get(2)?.let { it.count += 1 }

                println("\nКуплен \"${phoneIt?.name}\", по цене $priceIt}\n")
            }

            "4" -> {
                var profit = 0
                phones[base]?.forEach { i ->
                    profit += i.profit
                }
                println(
                    "Статистика продаж магазина в городе: ${this.city}:\nПродано телефонов:\n" +
                            "${phones[base]?.get(0)?.name} - ${phones[base]?.get(0)?.count} шт. На сумму ${
                                phones[base]?.get(
                                    0
                                )?.profit
                            }\n" +
                            "${phones[base]?.get(1)?.name} - ${phones[base]?.get(1)?.count} шт. На сумму ${
                                phones[base]?.get(
                                    1
                                )?.profit
                            }\n" +
                            "${phones[base]?.get(2)?.name} - ${phones[base]?.get(2)?.count} шт. На сумму ${
                                phones[base]?.get(
                                    2
                                )?.profit
                            }\n" +
                            "Общая сумма продаж: $profit"
                )
            }
            else -> println("Введено неверное значение!\nПопробуйте еще раз\n\n")

        }
    }


    override fun checkPhone(base: Int) {
//        var profit = 0
//        phones[base]?.forEach { i ->
//            profit += i.profit
//        }
//        println(
//            "Статистика продаж магазина в городе: ${this.city}:\nПродано телефонов:\n" +
//                    "${phones[base]?.get(0)?.name} - ${phones[base]?.get(0)?.count} шт. На сумму ${
//                        phones[base]?.get(
//                            0
//                        )?.profit
//                    }\n" +
//                    "${phones[base]?.get(1)?.name} - ${phones[base]?.get(1)?.count} шт. На сумму ${
//                        phones[base]?.get(
//                            1
//                        )?.profit
//                    }\n" +
//                    "${phones[base]?.get(2)?.name} - ${phones[base]?.get(2)?.count} шт. На сумму ${
//                        phones[base]?.get(
//                            2
//                        )?.profit
//                    }\n" +
//                    "Общая сумма продаж: $profit"
//        )
        if (this.repair) {
            println("Отремонтировать телефон?\n1. Да\n2. Нет")
            when (readln()) {
                "1" -> {
                    println("Телефон отремонтирован")
                    return
                }

                "2" -> {
                    println("Не нуждаетесь в ремонте")
                    buyPhone(base)
                }

                else -> println("Введено неверное значение")
            }

        } else {
            buyPhone(base)
        }


    }


}
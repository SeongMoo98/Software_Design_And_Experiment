package com.example.practice2

import java.util.*

enum class Menu(price : Int) {
    RAMEN(1500), HAMBERGER(1500), COLA(800), HOTBAR(1200), CHOCOLATEMILK(1500);
    var price = price
    fun get_Price(): Int {
        return price
    }
}

class Machine(){
    var menu :Menu? = null
    var Input_Money : Int? = null

    fun getChange() :Int?{
        var change : Int? = (Input_Money!! - menu!!.get_Price()) ?: return null;
        if(change!! < 0){
            println("현금이 부족합니다")
            change = null
        }
        else
            println("감사합니다. 잔돈반환 : ${change}")
        return change
    }

    fun getCoin(sc: Scanner) : Int?{
        println("Insert Coin : ")
        try{
            Input_Money = Integer.parseInt(sc.nextLine());
            println("$Input_Money 원을 넣었습니다.")
        }
        catch (e :Exception){
            println("돈을 넣지 않았습니다")
            println("다시 돈을 넣어주세요")
            Input_Money = null;
        }
        return Input_Money;
    }

    fun getMenu(sc : Scanner) : Menu? {
        var menuNum : Int?;
        println("=============MENU=============")
        println("| (1) 참깨라면     - 1,000원   |")
        println("| (2) 햄버거       - 1,500원   |")
        println("| (3) 콜라        -   800원   |")
        println("| (4) 핫바        - 1,200원   |")
        println("| (5) 초코우유     - 1,500원   |")
        println("Choose Menu : ")
        try{
            menuNum = Integer.parseInt(sc.nextLine())
            when(menuNum) {
                1 -> {
                    menu = Menu.RAMEN
                    println("참깨라면이 선택되었습니다.")
                }
                2 -> {
                    menu = Menu.HAMBERGER
                    println("햄버거가 선택되었습니다.")
                }
                3 -> {
                    menu = Menu.COLA
                    println("콜라가 선택되었습니다.")
                }
                4 -> {
                    menu = Menu.HOTBAR
                    println("핫바가 선택되었습니다.")
                }
                5 -> {
                    menu = Menu.CHOCOLATEMILK
                    println("초코우유가 선택되었습니다.")
                }
            }

        }
        catch (e : Exception){
            println("아무것도 선택하지 않았습니다")
            println("다시 선택해주세요.")
            menu = null;
        }
        return menu
    }
}


fun main(){
    var machine : Machine = Machine()
    do{
        var menu : Menu? = null
        var change : Int? = null
        var coin : Int? =null
        val sc : Scanner = Scanner(System.`in`)

        menu = machine.getMenu(sc) ?: continue;
        coin = machine.getCoin(sc) ?: continue;
        change = machine.getChange() ?: break;
    }while((menu == null) || (coin ==null))

}
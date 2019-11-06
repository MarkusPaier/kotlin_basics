import java.util.*

fun main(args: Array<String>) {
    println("Hello, ${args[0]}!")

    feedTheFish()

    // loop
    var bubbles = 0
    while (bubbles < 50) {
        bubbles++
    }

    // repeat
    repeat(2) {
        println("A fish is swimming")
    }

    // kotlin if statements examples
    /*val temperature = 10
    val isHot = if (temperature > 50)
        true
    else
        false
    println(isHot)

    val message = "You are ${ if (temperature > 50) 
        "friend" 
    else 
        "safe" 
    } fish"
    println(message)*/
}

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eat $food")

    //swim()
    //swim("slow")
    swim(speed = "slow")

    shouldChangeWater(day, 20, 50)
    shouldChangeWater(day)
    shouldChangeWater(day, dirty = 50)

    if (shouldChangeWater(day)) {
        println("Change the water today")
    }

    dirtyProcessor()
}

fun shouldChangeWater(
    day: String,
    temperature: Int = 22,
    dirty: Int = 20
) : Boolean {

    val isTooHot = temperature > 30
    val isDirty = dirty > 30
    val isSunday = day == "Sunday"

    fun isTooHot(temperature: Int) = temperature > 30
    fun isDirty(dirty: Int) = dirty > 30
    fun isSunday(day: String) = day == "Sunday"

    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else -> false
    }
}

//fun isTooHot(temperature: Int) = temperature > 30
//fun isDirty(dirty: Int) = dirty > 30
//fun isSunday(day: String) = day == "Sunday"

fun fishFood(day: String): String {
    /*var food = "fasting"
    when (day) {
        "Monday" -> food = "flakes"
        "Tuesday" -> food = "pellets"
        "Wednesday" -> food = "redworms"
        "Thursday" -> food = "granules"
        "Friday" -> food = "mosquitoes"
        "Saturday" -> food = "lettuce"
        "Sunday" -> food = "plankton"
    }
    return food*/
    // OR
    return when (day) {
        "Monday" -> "flakes"
        "Tuesday" -> "pellets"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Saturday" -> "lettuce"
        "Sunday" -> "plankton"
        else -> "fasting"
    }
}

fun randomDay(): String {
    val week = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(week.size)]
}

// set default value
fun swim(speed: String = "fast") {
    println("swimming $speed")
}

// lambdas
var dirty = 20

val waterFilter: (Int) -> Int = { dirty -> dirty / 2}
fun feedFish(dirty: Int) = dirty + 10

fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}

fun dirtyProcessor() {
    dirty = updateDirty(dirty, waterFilter)
    dirty = updateDirty(dirty, ::feedFish)
    dirty = updateDirty(dirty) {dirty ->
        dirty + 50
    }
    dirty = updateDirty(dirty, {dirty ->
        dirty + 50
    })
}
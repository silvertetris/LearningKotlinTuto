fun main() {
    var toTypedArray = readln().split(" ").map { it.toInt() }.toTypedArray()
    val p3 = toTypedArray[0]
    val p4 = toTypedArray[1]
    var p0 = toTypedArray[2]
    var triple =0
    var quad = 0

    triple+= p3/3
    quad+= p4/4
    var tripleRemain = p3%3
    var quadRemain = p4%4
    if(p0 - (3-tripleRemain + 4-quadRemain) < 0) {
        print(-1)
        return
    }
    while(true) {
        if(tripleRemain%3!=0) {
            tripleRemain++
            p0--
        }
        if(quadRemain%4!=0) {
            quadRemain++
            p0--
        }
        if(tripleRemain%3==0 && quadRemain%4==0) {
            break
        }
    }
    var maxX=-1
    for (y in 0..p0 / 3) {
        val remainder = p0 - 3 * y
        if (remainder % 4 == 0) {
            val x = remainder / 4
            maxX = maxOf(maxX, x)
        }
    }
    if(maxX==-1) {
        print(-1)
        return
    }
    quad+=maxX
    triple+=(p0-(maxX*4))/3
    print("$triple $quad")
}
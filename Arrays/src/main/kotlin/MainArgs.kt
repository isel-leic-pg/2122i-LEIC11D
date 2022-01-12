fun main(args: Array<String>) {
    println(args.size)
    if ( args.size>1 )
        args[1] = "Hello"
    for( arg in args )
        println(arg)
}
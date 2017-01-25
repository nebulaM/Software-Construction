# `example2`
where we discuss how one can maintain a list of Pokémon

## Pokémons and the Need for User-Defined Types

If you are familar with [Pokémon Go](http://www.Pokémongo.com/en-ca/) then you know that a significant aspect of game play involves keeping track of the Pokémon a trainer has caught (and not released).

Let us suppose that we wanted to keep track of only a few details for each Pokémon: name (Pokémon type, by default), Pokémon number (in the [Pokédex](http://Pokémondb.net/pokedex)) combat power and hit points.

We could do this in C in a few ways. Someone who did not know just a little bit of the C language could use an array for each of these Pokémon attributes: 

* an array for the names;
* an array for the Pokémon number;
* an array for the combat power;
* an array for the hit points.

In C, we could declare these arrays as follows:

```c
char    name[MAX_POKEMON][MAX_NAME_LENGTH];
int     number[MAX_POKEMON];
int     cp[MAX_POKEMON];
int     hp[MAX_POKEMON];
```

Presumably, we would use the `i`-th index of each array to refer to the appropriate attribute for the `i`-th Pokémon in some trainer's collection.

The use of a separate array for each attribute is a modeling choice. The use of four different arrays may be confusing to someone who is not familiar with a program that uses this modeling approach unless the code is well-documented. Even when the code is well documented, it is possible to make mistakes: if we had to write a method to *power-up* a Pokémon then we may update the combat power but not the hit points. In C, a solution to the problem of using different arrays is to use a language construct called `struct`. A `struct` allows one to group multiple elements into one data type.

> Wikipedia entry for `struct`: https://en.wikipedia.org/wiki/Struct_(C_programming_language)

We would define a Pokémon `struct` as follows:
```c
struct pokemon {
    char    name[MAX_NAME_LENGTH];
    int     number;
    int     cp;
    int     hp;
};
```
The lines of C code above do not declare a variable to be of type `struct pokemon`. They only define the `struct`.

We can then define an array of Pokémon thus:

```c
struct pokemon pokemonArray[MAX_POKEMON];
```

At this point it may be good to remind ourselves that we are assuming a trainer can only have a pre-defined `MAX_POKEMON` number of Pokémons. We would like to relax this assumption at a later stage.

Using `struct`s allows us to group related data in a more meaningful fashion. To retrieve the combat power of the `i`-th Pokémon in `pokemonArray`, we would use `pokemonArray[i].cp`.

The use of `struct`s simplifies code organization and readability, and this decreases the probability of errors. A `struct` in C allows us to define, at least _in part_, a new **datatype**.

We may also want to define custom actions on the Pokémon struct that we have just discussed. A simple action would be to *power up* a Pokémon. For simplicity, let us suppose that powering up increased a Pokémon's combat power by 30 and its health points by 2.

Our first attempt to define such a method may look like this:

```c
void power_up1(struct pokemon this_pokemon) {
    this_pokemon.cp += 30;
    this_pokemon.hp += 2;
}
```

Would this method achieve what we want? If we called this method as follows

```c
power_up1(pokemonArray[0]);
```

then we do not get the intended effect. The Pokémon at index `0` of the array does not actually change. The reason is that a **copy** of `pokemonArray[0]` is made and is passed to the C function `power_up1`. The copy is stored at a different location in memory and it is altered but the method does not alter `pokemonArray[0]`, which is stored at a different memory address. This approach to passing parameters to functions is called **pass-by-value**, where a copy of the value is made and passed to the function.

To achieve the intended effect, we will have to use **pointers**, which allow us to work with memory addresses.

The C function that does work looks like this:

```c
void power_up2(struct pokemon *this_pokemon) {
    (*this_pokemon).cp += 30;
    (*this_pokemon).hp += 2;
}
```

In the above function, we are stating that `this_pokemon` is a pointer (because of the `*` operator) and that it stores a memory location where one might expect to find a `struct pokemon` type. The `struct pokemon` at that location is referenced using the syntax `*this_pokemon`.

To pass the address of the `struct` we wish to change, we would invoke this method thus:

```c
power_up2(&pokemonArray[0]);
```

The `&` operator passes the address of the variable that immediately follows it, and in the example above it is the address of the `pokemonArray[0]`.

We will deliberately not talk more about [pointers](https://en.wikibooks.org/wiki/C_Programming/Pointers_and_arrays) here but one should experiment with pointers to understand what they enable.
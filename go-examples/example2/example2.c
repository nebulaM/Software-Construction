#include <stdio.h>
#include <string.h>

#define MAX_POKEMON 250
#define MAX_NAME_LENGTH 20

// Let us define a struct that represents a Pokémon
struct pokemon {
    char    name[MAX_NAME_LENGTH];
    int     number;
    int     cp;
    int     hp;
};

// a simplistic power_up method
// increases cp by 30 and hp by 2
// this is not helpful because parameter is passed-by-value
void power_up1(struct pokemon this_pokemon) {
    this_pokemon.cp += 30;
    this_pokemon.hp += 2;
}


// a simplistic power_up method
// increases cp by 30 and hp by 2
// we want to alter the pokemon so we will have to use pointers!
void power_up2(struct pokemon *this_pokemon) {
    (*this_pokemon).cp += 30;
    (*this_pokemon).hp += 2;
}

void main( ) {
    
    // declare an array of Pokémon
    struct pokemon pokemonArray[MAX_POKEMON];
    
    // how many pokemon do we actually have?
    // we have declared an array of MAX_POKEMON but we may really have less
    int nPokemon = 0;
    
    // add some Pokémon
    strcpy(pokemonArray[nPokemon].name, "Bulbasaur");
    pokemonArray[nPokemon].number   = 1;
    pokemonArray[nPokemon].cp       = 252;
    pokemonArray[nPokemon].hp       = 43;
    nPokemon++;
    
    strcpy(pokemonArray[nPokemon].name, "Eevee");
    pokemonArray[nPokemon].number   = 133;
    pokemonArray[nPokemon].cp       = 567;
    pokemonArray[nPokemon].hp       = 78;
    nPokemon++;
    
    // let us know print some stuff
    
    printf("The name of the second Pokémon is %s.\n", pokemonArray[1].name);
    printf("The combat power of the first Pokémon is %d.\n", pokemonArray[0].cp);
    
    // let us power up the Bulbasaur
    
    // attempt 1, which does not work
    power_up1(pokemonArray[0]);
    printf("The combat power of the first Pokémon -- after a power-up -- is %d.\n", pokemonArray[0].cp);
    
    // attempt 2, which does work
    power_up2(&pokemonArray[0]);
    printf("The combat power of the first Pokémon -- after a power-up -- is %d.\n", pokemonArray[0].cp);
    
}
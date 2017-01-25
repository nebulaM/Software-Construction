#include <stdio.h>

#define NUM_POKEMON 10
#define NAME_LENGTH 20

/*
 * This is a simple program to print the names of some Pokemon.
 */

void main() {

    // let's declare an array of strings,
    // which in C is a 2-dimensional array of characters
    char pokemonNames[NUM_POKEMON][NAME_LENGTH] = {"Pikachu", "Cleafiry", "Victreebell", "Eevee", "Flareon", "Rapidash", "Charmander", "Ponyta", "Dratini", "Snorlax"};
    
    
    // and then we can print the names using a 'for' loop
    printf("Here are the names of some Pokemon\n");
    printf("==================================\n");
    
    for (int i = 0; i < NUM_POKEMON; ++i) {
        printf("%s \n", pokemonNames[i]);
    }

}

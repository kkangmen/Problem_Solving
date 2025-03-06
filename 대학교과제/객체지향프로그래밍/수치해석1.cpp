#include <stdio.h>

int main()

{

float f = 0.1 ;

float tmp, realEmach, Emach=1.0 ;

float small = 1.0 , realSmall ;

for ( ;; )

{

   tmp = 1.0 + Emach ;

   if ( tmp == 1.0 ) 

      break ;

   else

   {

      realEmach = Emach ;

      Emach = Emach / 2.0 ;

   }

}

printf("f=0.1=%.20e Emach=%.20e\n", f, realEmach ) ; 

for (;;)

{

    small = small/2.0 ;

    if ( small == 0.0 )

       break ;

            realSmall = small ;

}

printf("small=%.20e\n", realSmall ) ; 

return 0;

 }
#include <stdlib.h>

int fct(int a, int b, int c, int d, int e, int f){
    if (a<b>c==d<=f) return 1 ;
    else if (a>=b>=c>d>=e>f>=10) return 2 ;
    else if (a==b==d==10) return 3 ;
    else if (a<=b<c<=d<e<=f<10) return 4 ;
    else if (a=b=c=d=e=f=10) return 5 ;
    else if (a<b>c<d>e<f>10) return 6 ;
    else if (a>b<c>d<e>f<10) return 7 ;
    else return 0;
}

int main () {
    //empty main
    if (fct(1,2,3,4,5,6) == 4){
        return 1 ;
    };
    return 0;
}
#include <stdlib.h>

struct S2 {
    int a ;
    int b ;
};

int fct(struct S2 * ab, int c) {
    while ( (ab->a < 0) || (ab->b - 1 < 0) && (c == 0))
       return 0 ;
    return 1;
}

int main() {
    struct S2 * e ;
    e = malloc(sizeof(struct S2));
    return fct(e, 5) ;
}
#include <stdio.h>

int main()
{
    int a, b, *pa = &a, *pb = &b;
    
    scanf("%d%d", pa, pb);
    printf("%d", *pa+*pb);
    
    return 0;
}
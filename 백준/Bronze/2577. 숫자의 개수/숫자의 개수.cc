#include <stdio.h>

int main(void)
{
    int num[10]={0,};
    int a,b,c;
    scanf("%d %d %d",&a,&b,&c);
    int gop = a*b*c;
    while(gop)
    {
        switch(gop%10)
        {
            case 0:
                num[0]++;
                break;
            case 1:
                num[1]++;
                break;
            case 2:
                num[2]++;
                break;
            
            case 3:
                    num[3]++;
                    break;
            case 4:
                num[4]++;
                break;
            case 5:
                num[5]++;
                break;
            case 6:
                num[6]++;
                break;
            case 7:
                num[7]++;
                break;
            case 8:
                num[8]++;
                break;
            case 9:
                num[9]++;
                break;
        }
        gop /=10;
    }
    for(int i=0; i<10; i++)
    {
        printf("%d\n",num[i]);
    }
    
}
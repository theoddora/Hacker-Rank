#include <stdio.h>
#include <vector>

using namespace std;

int main(void)
{
    //read input
    int n, m;
    scanf("%d %d", &n, &m);

    int a[n], b[m];
    for(int i = 0; i < n; ++i)
    {
       scanf("%d", &a[i]); 
    }

    for(int i = 0; i < m; ++i)
    {
       scanf("%d", &b[i]); 
    }

    int minInB = b[0];
    for(int i = 1; i < m; ++i)
    {
       if(b[i] < minInB)
       {
           minInB = b[i];
       }
    }

    //preparing
    vector<int> multipliersB;
    for(int j = 1; j <= minInB; ++j)
    {
        if(minInB % j == 0)
        {
            multipliersB.push_back(j);
        }
    }
    

    int counter = 0;
    bool isInSet;
    int x;

    for(int i = 0; i < multipliersB.size(); ++i)
    {
        x = multipliersB[i];
        isInSet = true;

        for(int i = 0; i < n; ++i)
        {
            if(x % a[i] != 0)
            {
                isInSet = false;
                break;
            }
        }
        if(isInSet)
        {
            for(int i = 0; i < m; ++i)
            {
                if(b[i] % x != 0)
                {
                    isInSet = false;
                    break;
                }
            }

            if(isInSet)
            {
                counter++;
            }
        }
    }

    printf("%d", counter);
    
    return 0;
}
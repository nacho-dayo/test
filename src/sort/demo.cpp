#include<iostream>
#include<iomanip>
#include<set>
#include<algorithm>
#include<climits>
#include<stack>
#include<cmath>
#include<queue>
#include<map>
#include<string>
#include<sstream>
#include<cstdio>
#include<cstring>
#define rep(i,a,b) for(int i=a;i<b;i++)
#define Rep(i,a,b) for(int i=a;i>b;i--)
#define lowbit(i) (i & (-i))

using namespace std;
typedef unsigned long long ull;
typedef long long ll;
typedef pair<int,int> pii;
typedef pair<int,string> pis;
const int N = 1e6 + 10;
const int mod = 10000;

int T,n,m;
string s;
ll a[500];

void solve(){    
    double a[4] = {0.10116, 0.24778, 0.58701, 0.06405};
    double b[4] = {0.0872, 0.32834, 0.49614, 0.08832};
    double W[4];
    for(int i = 0; i < 4; i++){
        double t = 0;
        for(int j = 0; j < 4; j++){
            t += sqrt(a[j] * b[j]);
        }
        W[i] = sqrt(a[i] * b[i]) / t;
    }
    for(int i = 0; i < 4; i++){
        cout<<W[i]<<endl;
    }
    return ;
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    //cin>>T;
    T = 1;
    while(T--){
        solve();
    }
    return 0;
}

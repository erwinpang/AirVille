#define _XOPEN_SOURCE

#include <stdio.h>
#include <stdlib.h>
#include <errno.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <sys/resource.h>
#include <time.h>

#define NUM_CHILDREN 4
#define ULONG_MAX 0xFFFFFFFFUL

int print_if_error(int syscall_val){
    if(syscall_val < 0){
        perror("fork");
        exit(errno);
    }
    else {
        return syscall_val;
    }
}

char* cuserid_wrapper(){
    char* val = cuserid(NULL);
    if (val == NULL) {
        perror("cuserid");
        exit(errno);
    } else {
        return val;
    }
}

void print_id(){
    printf("Process ID: %d \n", getpid());
    printf("Effective User ID: %d \n", geteuid());
    printf("Real User ID: %d \n", getuid());
    printf("Effective Group User ID: %d \n", getegid());
    printf("Reaul Group ID: %d \n", getgid());
}

void process(long start, int child_number){
    sleep(2);
    long i;
    for(i = start; i < 11; i+=2){
        int result = (int) binomal(i, i - 2);
        printf("Child %d: \n", child_number);
        printf("The binomial coefficient of %d and %d: %d \n", i, i-2, result);
    }
}

/*
 * Taken from http://rosettacode.org/wiki/Evaluate_binomial_coefficients#C
 */

static unsigned long gcd_ui(unsigned long x, unsigned long y) {
    unsigned long t;
    if (y < x) { t = x; x = y; y = t; }
    while (y > 0) {
        t = y;  y = x % y;  x = t;
    }
    return x;
}

unsigned long binomial(unsigned long n, unsigned long k) {
    unsigned long max = ULONG_MAX;
    unsigned long d, g, r = 1;
    if (k == 0) return 1;
    if (k == 1) return n;
    if (k >= n) return (k == n);
    if (k > n/2) k = n-k;
    for (d = 1; d <= k; d++) {
        if (r >= max/n) {  /* Possible overflow */
            unsigned long nr, dr;  /* reduced numerator / denominator */
            g = gcd_ui(n, d);  nr = n/g;  dr = d/g;
            g = gcd_ui(r, dr);  r = r/g;  dr = dr/g;
            if (r >= max/nr) return 0;  /* Unavoidable overflow */
            r *= nr;
            r /= dr;
            n--;
        } else {
            r *= n--;
            r /= d;
        }
    }
    return r;
}

int main(){
    pid_t child1_pid, child2_pid, child3_pid, child4_pid;
    int status = 0;
    child1_pid = print_if_error(fork());
    if (child1_pid == 0) {
        print_id();
        printf("Computing binomial coefficient");
    }
    child2_pid = print_if_error(fork());
    if (child2_pid == 0){
        sleep(1);
        print_id();
        process(2, 2);
    }
    else {
        waitpid(child1_pid, &status, 0);
        printf("child1 terminated\n");
        
        child3_pid = print_if_error(fork());
        
        if(child3_pid == 0){
            sleep(2);
            print_id();
            process(3, 3);
        }
        else{
            waitpid(child3_pid, &status, 0);
            printf("child 3 terminated\n");
        }
        
        waitpid(child2_pid, &status, 0);
        printf("child2 terminated\n");
        
        child4_pid = print_if_error(fork());
        if(child4_pid == 0){
            sleep(1);
            print_id();
            system("ls -l");
        } else {
            waitpid(child4_pid, &status, 0);
            printf("child4 terminated\n");
        }
    }
    
    return 0;
}









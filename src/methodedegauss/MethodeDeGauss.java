// Ben Said  Zine El Abidine
package methodedegauss;

/**
 *
 * @author Zinou
 */

/* la methode du pivot de Gauss            */
public class MethodeDeGauss {
    


/* Methode d'affichage des valeurs contenues   */
/* dans un tableau d entier a 1 indice        */
  
  static void affichageVecteur(int [] t) {
    for ( int i = 0 ; i < t.length ; i = i+1 ) {
      System.out.println(t[i]); }
  }

/* Methode d'affichage des valeurs contenues   */
/* dans un tableau d entier a 2 indices       */
  
  static void affichageMatrice(int [][] t) {
    for ( int i = 0 ; i < t.length ; i = i+1 ) {
      for ( int j = 0 ; j < t[i].length ; j = j+1 ) {
            System.out.print(t[i][j] + " | "); }
         System.out.println(); }
  }
  
  
/////////////////////////////////////////////////

/* Methode de clonage d'un tableau             */
/* a 1 indice de double                        */

  static int [] clone(int [] t) {
    int n = t.length;
    int [] nt = new int[n];
    for ( int i = 0 ; i < n ; i = i+1 ) {
      nt[i] = t[i]; }
    return nt;
  }

/* Methode de clonage d'un tableau             */
/* a 2 indices de double                       */

  static int [][] clone(int [][] t) {
    int n = t.length;
    int m = t[0].length;
    int [][] nt = new int[n][m];
    for ( int i = 0 ; i < n ; i = i+1 ) {
      for ( int j = 0 ; j < m ; j = j+1 ) {
        nt[i][j] = t[i][j]; } }
    return nt;
  }

/* Permutation de Gauss                        */

  static void permutation(int l,int [][] m,int [] v) {
    int ll;
    int n = v.length;
    int aux;
    ll = l;
    while ( m[ll][l] == 0 ) {
      ll = ll+1; }
    for ( int i = l ; i < n ; i = i+1 ) {
      aux = m[l][i];
      m[l][i] = m[ll][i];
      m[ll][i] = aux; }
    aux = v[l];
    v[l] = v[ll];
    v[ll] = aux;
  }

/* Transformation de Gauss                     */

  static void transformation(int [][] m,int [] v) {
  int n = v.length;
  int facteur;
  for ( int i = 1 ; i < n ; i++ ) {
    if ( m[i-1][i-1] == 0.0 )
      permutation(i-1,m,v);
    for ( int j = i ; j < n ; j++ ) {
      facteur = m[j][i-1]/m[i-1][i-1];
      for ( int k = i-1 ; k < n ; k++ ) {
        m[j][k] = m[j][k] - m[i-1][k]*facteur; }
      v[j] = v[j] - v[i-1]*facteur;  } }
  }

/* Extraction de Gauss                         */
  
  static int [] extraction(int [][] a,int [] b) {
    int n = b.length;
    int [] v = new int[n];
    v[n-1] = b[n-1]/a[n-1][n-1];
    for ( int i = n-2 ; i >= 0 ; i = i-1 ) {
      v[i] = b[i];
      for ( int j = n-1 ; j > i ; j = j-1 ) {
        v[i] = v[i] - v[j]*a[i][j]; }
      v[i] = v[i]/a[i][i]; }
    return v;
  }
      
/* Resolution de Gauss                         */

  static int [] resolution(int [][] a,int [] b) {
    int [] v;
    transformation(a,b);
    v = extraction(a,b);
    return v;
  }
  
/* Resolution de Gauss                         */
/* sur une copie des 2 tableaux en parametres  */

  static int [] resolutionGauss(int [][] a,int [] b) {
    int [][] ca = clone(a);
    int [] cb = clone(b);
    int [] v;
    v = resolution(ca,cb);
    return v;
  }

/////////////////////////////////////////////////
  
/* Programme principal                         */

  public static void main(String [] args) {
    int [][] a = { {  1, 0, 1,-1, 1 },
                      {  4, 0, 5, 1,-1 },
                      {  3, 1, 2, 0, 3 },
                      { -2, 3,-2,16, 3 },
                      {  6, 5, 0,-3,19 } };
    int [] b = { 1, 2,-1, 4, 3 };
    int [] v;
    int [] w;
    System.out.println("Matrice A:");
    affichageMatrice(a);
    System.out.println();
    System.out.println("Vecteur B:");
    affichageVecteur(b);
    System.out.println();
    v = resolutionGauss(a,b);
    System.out.println("Vecteur V trouvé par Gauss :");
    affichageVecteur(v);
    }
}


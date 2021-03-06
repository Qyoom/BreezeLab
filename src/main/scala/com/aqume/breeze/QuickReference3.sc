package com.aqume.breeze

import breeze.linalg._
//import breeze.numerics._

object QuickReference3 {

	//------- Data objects set up ------------------//
  
  val v1 = DenseVector((1 to 10).toArray)         //> v1  : breeze.linalg.DenseVector[Int] = DenseVector(1, 2, 3, 4, 5, 6, 7, 8, 9
                                                  //| , 10)
  val v2 = DenseVector((11 to 20).toArray)        //> v2  : breeze.linalg.DenseVector[Int] = DenseVector(11, 12, 13, 14, 15, 16, 1
                                                  //| 7, 18, 19, 20)
  
  val v3 = DenseVector(1,1,3,3,3,5,7,9,14,15)     //> v3  : breeze.linalg.DenseVector[Int] = DenseVector(1, 1, 3, 3, 3, 5, 7, 9, 1
                                                  //| 4, 15)
  
  val m1 = new DenseMatrix(2, 5, (1 to 10).toArray)
                                                  //> m1  : breeze.linalg.DenseMatrix[Int] = 1  3  5  7  9   
                                                  //| 2  4  6  8  10  
  val m2 = new DenseMatrix(2, 5, (11 to 20).toArray)
                                                  //> m2  : breeze.linalg.DenseMatrix[Int] = 11  13  15  17  19  
                                                  //| 12  14  16  18  20  
  
  val m3 = new DenseMatrix(5, 2, (11 to 20).toArray)
                                                  //> m3  : breeze.linalg.DenseMatrix[Int] = 11  16  
                                                  //| 12  17  
                                                  //| 13  18  
                                                  //| 14  19  
                                                  //| 15  20  
  val m4 = new DenseMatrix(2, 5, Array(2,4,3,5,7,6,9,8,10,10))
                                                  //> m4  : breeze.linalg.DenseMatrix[Int] = 2  3  7  9  10  
                                                  //| 4  5  6  8  10  
  println("\nm1:\n" + m1)                         //> 
                                                  //| m1:
                                                  //| 1  3  5  7  9   
                                                  //| 2  4  6  8  10  
  println("\nm2:\n" + m2)                         //> 
                                                  //| m2:
                                                  //| 11  13  15  17  19  
                                                  //| 12  14  16  18  20  
  println("\nm3:\n" + m3)                         //> 
                                                  //| m3:
                                                  //| 11  16  
                                                  //| 12  17  
                                                  //| 13  18  
                                                  //| 14  19  
                                                  //| 15  20  
  println("\nm4:\n" + m4)                         //> 
                                                  //| m4:
                                                  //| 2  3  7  9  10  
                                                  //| 4  5  6  8  10  
  
  
  //-------- Operations -----------------------------//
  
  // Elementwise addition (both operators work)
  v1 + v2                                         //> res0: breeze.linalg.DenseVector[Int] = DenseVector(12, 14, 16, 18, 20, 22, 2
                                                  //| 4, 26, 28, 30)
  v1 :+ v2                                        //> res1: breeze.linalg.DenseVector[Int] = DenseVector(12, 14, 16, 18, 20, 22, 2
                                                  //| 4, 26, 28, 30)
  println("\nm1 + m2:\n" + (m1 + m2))             //> 
                                                  //| m1 + m2:
                                                  //| 12  16  20  24  28  
                                                  //| 14  18  22  26  30  
  // with transposition
  println("\nm1 + m3:\n" + (m1 + m3.t))           //> 
                                                  //| m1 + m3:
                                                  //| 12  15  18  21  24  
                                                  //| 18  21  24  27  30  
  
  // Elementwise subtraction
  v2 :- v1                                        //> res2: breeze.linalg.DenseVector[Int] = DenseVector(10, 10, 10, 10, 10, 10, 1
                                                  //| 0, 10, 10, 10)
  v2 - v1                                         //> res3: breeze.linalg.DenseVector[Int] = DenseVector(10, 10, 10, 10, 10, 10, 1
                                                  //| 0, 10, 10, 10)
  v1 - v2                                         //> res4: breeze.linalg.DenseVector[Int] = DenseVector(-10, -10, -10, -10, -10, 
                                                  //| -10, -10, -10, -10, -10)
  // Elementwise multiplication
  //v1 * v2 ERROR
  v1 :* v2                                        //> res5: breeze.linalg.DenseVector[Int] = DenseVector(11, 24, 39, 56, 75, 96, 1
                                                  //| 19, 144, 171, 200)
  println("\nm1 * m2:\n" + (m1 :* m2))            //> 
                                                  //| m1 * m2:
                                                  //| 11  39  75  119  171  
                                                  //| 24  56  96  144  200  
  // Elementwise comparison
  (v1 :< v2).toArray                              //> res6: Array[Boolean] = Array(true, true, true, true, true, true, true, true
                                                  //| , true, true)
  (v1 :< v3).toArray                              //> res7: Array[Boolean] = Array(false, false, false, false, false, false, fals
                                                  //| e, true, true, true)
  println(
  	(m1 :< m4).toDenseMatrix
  )                                               //> true  false  true   true   true   
                                                  //| true  true   false  false  false  
  // Elementwise equals
  (v1 :== v3).toArray                             //> res8: Array[Boolean] = Array(true, false, true, false, false, false, true, 
                                                  //| false, false, false)
  println(
  	(m1 :== m4).toDenseMatrix
  )                                               //> false  true   false  false  false  
                                                  //| false  false  true   true   true   
  // Inplace scalar addition NOTE: Inplace operations reassign values to same Vector and Matrix
  v1                                              //> res9: breeze.linalg.DenseVector[Int] = DenseVector(1, 2, 3, 4, 5, 6, 7, 8, 
                                                  //| 9, 10)
  val v5 = v1 :+= 10                              //> v5  : breeze.linalg.DenseVector[Int] = DenseVector(11, 12, 13, 14, 15, 16, 
                                                  //| 17, 18, 19, 20)
  v5                                              //> res10: breeze.linalg.DenseVector[Int] = DenseVector(11, 12, 13, 14, 15, 16,
                                                  //|  17, 18, 19, 20)
  v1                                              //> res11: breeze.linalg.DenseVector[Int] = DenseVector(11, 12, 13, 14, 15, 16,
                                                  //|  17, 18, 19, 20)
  v2                                              //> res12: breeze.linalg.DenseVector[Int] = DenseVector(11, 12, 13, 14, 15, 16,
                                                  //|  17, 18, 19, 20)
  // play
  (v5 :== v2).toArray                             //> res13: Array[Boolean] = Array(true, true, true, true, true, true, true, tru
                                                  //| e, true, true)
  v5                                              //> res14: breeze.linalg.DenseVector[Int] = DenseVector(11, 12, 13, 14, 15, 16,
                                                  //|  17, 18, 19, 20)
  v2                                              //> res15: breeze.linalg.DenseVector[Int] = DenseVector(11, 12, 13, 14, 15, 16,
                                                  //|  17, 18, 19, 20)
  
  (m1 :+= 10) :== m2                              //> res16: breeze.linalg.DenseMatrix[Boolean] = true  true  true  true  true  
                                                  //| true  true  true  true  true  
  
  // Inplace scalar subtraction (the colon (:) seems to have NO EFFECT!)
  val v8 = DenseVector(5,4,3)                     //> v8  : breeze.linalg.DenseVector[Int] = DenseVector(5, 4, 3)
  v8 :- 2                                         //> res17: breeze.linalg.DenseVector[Int] = DenseVector(3, 2, 1)
  v8 - 2                                          //> res18: breeze.linalg.DenseVector[Int] = DenseVector(3, 2, 1)
  v8                                              //> res19: breeze.linalg.DenseVector[Int] = DenseVector(5, 4, 3)
  v8 :-= 2                                        //> res20: breeze.linalg.DenseVector[Int] = DenseVector(3, 2, 1)
  v8 -= 2                                         //> res21: breeze.linalg.DenseVector[Int] = DenseVector(1, 0, -1)
  
  // Inplace scalar multiplication
  m1 :*= 2                                        //> res22: breeze.linalg.DenseMatrix[Int] = 22  26  30  34  38  
                                                  //| 24  28  32  36  40  
  // Vector dot product
  v1 dot v2                                       //> res23: Int = 2485
  
  val v6 = m1(0,::)                               //> v6  : breeze.linalg.Transpose[breeze.linalg.DenseVector[Int]] = Transpose(D
                                                  //| enseVector(22, 26, 30, 34, 38))
  val v7 = m1(1,::)                               //> v7  : breeze.linalg.Transpose[breeze.linalg.DenseVector[Int]] = Transpose(D
                                                  //| enseVector(24, 28, 32, 36, 40))
  v6.t dot v7.t                                   //> res24: Int = 4960
  
  // Elementwise max
  v1                                              //> res25: breeze.linalg.DenseVector[Int] = DenseVector(11, 12, 13, 14, 15, 16,
                                                  //|  17, 18, 19, 20)
  max(v1)                                         //> res26: Int = 20
  println("\nm1:\n" + m1 + "\n")                  //> 
                                                  //| m1:
                                                  //| 22  26  30  34  38  
                                                  //| 24  28  32  36  40  
                                                  //| 
  max(m1)                                         //> res27: Int = 40
  // Elementwise argmax
  argmax(v1)                                      //> res28: Int = 9
  argmax(m1)                                      //> res29: (Int, Int) = (1,4)
}
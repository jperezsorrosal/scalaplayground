object Main {

  def main(args: Array[String]): Unit = {

    import Dfa._

    val dfa = newDfa { dfa =>

      dfa states {
        Seq(S0, S1, S2, S3)
      }

      dfa finalStates {
        Seq(S2)
      }

      dfa transitions { transition =>
        transition on '0' from S0 to S1
        transition on '1' from S0 to S3
        transition on '0' from S1 to S2
        transition on '1' from S1 to S1
        transition on '0' from S2 to S2
        transition on '1' from S2 to S1
        transition on '0' from S3 to S3
        transition on '1' from S3 to S3
      }
    } startFrom S0 withInput "010101011110110110000"

    val hasInputAccepted = dfa.run
  }

}
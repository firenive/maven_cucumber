package steps.part1.chapter5;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class BoardSteps {
    private List<List<String>> board;

    @Given("a board like this:")
    public void aBoardLikeThis(DataTable table) {
        this.board = table.asLists();
    }



    @When("player x plays in row {int}, column {int}")
    public void playerXPlays(int row, int col) {
        board.get(row).set(col, "x");
        System.out.println(board.toString());
    }

    @Then("the board should look like this:")
    public void boardLookLike(DataTable expectedTable) {
        DataTable actualTable = DataTable.create(board);
        expectedTable.diff(actualTable);
    }


}

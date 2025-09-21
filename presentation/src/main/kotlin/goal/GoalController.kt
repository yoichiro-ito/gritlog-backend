package goal

import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1/goal")
class GoalController {


    @Operation(description = "目標登録")
    @PostMapping
    fun register() {

    }

    @Operation(description = "目標詳細表示")
    @GetMapping("/{id}")
    fun detail() {
    }

    @Operation(description = "目標編集")
    @PutMapping("/{id}")
    fun edit() {

    }

    @Operation(description = "目標削除")
    @DeleteMapping("/{id}")
    fun delete(){

    }


}
package json.operation

import play.api.libs.json._
import plm.universe.Operation
import plm.universe.GridWorldCellOperation
import plm.universe.bugglequest.BuggleOperation
import play.api.libs.json.Json.toJsFieldJsValueWrapper

object OperationToJson {
  
  def operationsWrite(operations: Array[Operation]): JsValue = {
    var array = new JsArray()
    operations.foreach { operation =>
      array = array :+ operationWrite(operation)
    }
    return array
  }
  
  def operationWrite (operation: Operation): JsValue = {
    var json: JsValue = null
    operation match {
      case buggleOperation: BuggleOperation =>
        json = BuggleOperationToJson.buggleOperationWrite(buggleOperation)
      case gridWorldCellOperation: GridWorldCellOperation =>
        json = GridWorldCellOperationToJson.gridWorldCellOperationWrite(gridWorldCellOperation)
      case _ =>
        Json.obj(
          "operation" -> "arf"    
        )
    }
    json = json.as[JsObject] ++ Json.obj(
      "type" -> operation.getName
    )
    return json
  }
}
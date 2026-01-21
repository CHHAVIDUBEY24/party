import org.moqui.context.ExecutionContext

ExecutionContext ec = context.ec

//if(partyId==null)
//{
//    ec.message("${partyId} is required")
//    return
//}
//if(firstName==null)
//{
//    ec.message("${firstName} is required")
//}
//if(lastName==null)
//{
//    ec.message("${lastName} is required")
//}
// select * from party where partyId="${}"  limit = 1;
def party = ec.entity.find("party.Party").condition("partyId",partyId).one()

//
if(party == null){
    ec.message("${partyId} does not exist")

    return
}
if(party.partyTypeEnumId != "PERSON"){
    ec.message("${partyId} Is not PERSON type" )

    return

}
// insert into Person ("firstName","lastName") value (?,?);
ec.entity.makeValue("party.Person").setAll(context).create()

context.responseMessage ="Person ${firstName} ${lastName} created successfully!"
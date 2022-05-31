import "./mailList.css"

const MailList = () => {
    //todo if user exist
  return (
    <div className="mail">
      <h1 className="mailTitle">Збережіть час та гроші!</h1>
      <span className="mailDesc">Зареєструйтеся, і ми надішлемо вам найкращі пропозиції</span>
      <div className="mailInputContainer">
        <button>Зареєструватись</button>
      </div>
    </div>
  )
}

export default MailList
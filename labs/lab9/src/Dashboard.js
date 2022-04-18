import PageRoutes from "./routes/PageRoutes";
import Header from "./containers/Header";

const Dashboard = () => {
  return (
    <React.Fragment>
      <div>
        <Header />
      </div>
      <div>
        <PageRoutes />
      </div>
    </React.Fragment>
  );
};

export default Dashboard;

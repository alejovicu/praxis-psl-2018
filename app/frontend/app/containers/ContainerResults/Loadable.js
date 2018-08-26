/**
 *
 * Asynchronously loads the component for ContainerResults
 *
 */

import Loadable from 'react-loadable';

export default Loadable({
  loader: () => import('./index'),
  loading: () => null,
});
